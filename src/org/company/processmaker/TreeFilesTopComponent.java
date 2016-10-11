/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.company.processmaker;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.JTextComponent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.apache.commons.lang.StringEscapeUtils;
import org.netbeans.api.editor.EditorRegistry;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.cookies.OpenCookie;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.util.Exceptions;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//org.company.googletoolbar//TreeFiles//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "TreeFilesTopComponent",
        iconBase = "org/company/processmaker/icon24.png",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "explorer", openAtStartup = true)
@ActionID(category = "Window", id = "org.company.googletoolbar.TreeFilesTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_TreeFilesAction",
        preferredID = "TreeFilesTopComponent"
)
@Messages({
    "CTL_TreeFilesAction=TreeFiles",
    "CTL_TreeFilesTopComponent=TreeFiles Window",
    "HINT_TreeFilesTopComponent=This is a TreeFiles window"
})
public final class TreeFilesTopComponent extends TopComponent {

    public TreeFilesTopComponent() {
        initComponents();

        setName(Bundle.CTL_TreeFilesTopComponent());
        setToolTipText(Bundle.HINT_TreeFilesTopComponent());
        // new codes
        instance = this;

        MouseListener ml = new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int selRow = jTree1.getRowForLocation(e.getX(), e.getY());
                TreePath selPath = jTree1.getPathForLocation(e.getX(), e.getY());

                if (selRow != -1) {
                    if (e.getClickCount() == 1) {
                        //mySingleClick(selRow, selPath);
                    } else if (e.getClickCount() == 2) {

                        DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
                        if (node == null) {
                            return;
                        }
                        Object nodeInfo = node.getUserObject();
                        int node_level = node.getLevel();

                        if (node_level < 2) {
                            return;
                        }

                        // for each dyna form
                        if (node_level == 2) {

                            Global gl_obj = Global.getInstance();

                            //myDoubleClick(selRow, selPath);
                            conf = Config.getInstance();

                            DefaultMutableTreeNode parent = (DefaultMutableTreeNode) node.getParent();
                            String parentName = (String) parent.getUserObject();

                            // handle triggers
                            if (parentName.equals("Triggers")) {

                                String filePath = "";
                                for (String[] s : res_trigger) {

                                    if (s[0].equals(nodeInfo.toString())) {
                                        // get path of dyna in xml forms
                                        filePath = conf.tmp + "triggers/" + s[3] + "/" + s[2] + ".php";
                                        break;
                                    }

                                }

                                File toAdd = new File(filePath);

                                try {
                                    DataObject dObject = DataObject.find(FileUtil.toFileObject(toAdd));

                                    dObject.getLookup().lookup(OpenCookie.class).open();
                                    // dont listen for exist listen files
                                    if (existFile(filePath)) {
                                        return;
                                    }
                                    dObject.addPropertyChangeListener(new PropertyChangeListener() {
                                        @Override
                                        public void propertyChange(PropertyChangeEvent evt) {
                                            if (DataObject.PROP_MODIFIED.equals(evt.getPropertyName())) {
                                                //fire a dummy event
                                                if (!Boolean.TRUE.equals(evt.getNewValue())) {

                                                    /*String msg = "Saved to" + evt.toString();
                                                    NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
                                                    DialogDisplayer.getDefault().notify(nd);*/
                                                    TopComponent activeTC = TopComponent.getRegistry().getActivated();
                                                    DataObject dataLookup = activeTC.getLookup().lookup(DataObject.class);
                                                    String filePath = FileUtil.toFile(dataLookup.getPrimaryFile()).getAbsolutePath();

                                                    File userFile = new File(filePath);
                                                    String fileName = userFile.getName();
                                                    fileName = fileName.substring(0, fileName.lastIndexOf("."));

                                                    try {
                                                        String content = new String(Files.readAllBytes(Paths.get(filePath)));
                                                        // remote php tag and info "<?php //don't remove this tag! \n"
                                                        content = content.substring(6, content.length());

                                                        String query = "update triggers set TRI_WEBBOT = '" + StringEscapeUtils.escapeSql(content) + "' where TRI_UID = '" + fileName + "'";
                                                        GooglePanel.updateQuery(query);

                                                    } catch (Exception e) {
                                                        //Exceptions.printStackTrace(e);
                                                        String msg = "Can not update trigger";
                                                        NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
                                                        DialogDisplayer.getDefault().notify(nd);
                                                    }

                                                }

                                            }

                                        }
                                    });

                                } catch (DataObjectNotFoundException ex) {
                                    //Exceptions.printStackTrace(ex);
                                    String msg = "Trigger not found";
                                    NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
                                    DialogDisplayer.getDefault().notify(nd);
                                }

                                return;
                            }

                            List<String[]> res_dyna = gl_obj.getDyna();
                            String FileDir = "";
                            for (String[] s : res_dyna) {

                                if (s[1].equals(nodeInfo.toString())) {
                                    // get path of dyna in xml forms
                                    FileDir = s[3];
                                    break;
                                }

                            }

                            //String msg = "selRow" + nodeInfo.toString() + "|" + conf.getXmlForms() + FileDir;
                            String filePath = conf.getXmlForms() + FileDir + ".xml";
                            if (conf.isRemote()) {
                                String[] res = FileDir.split("/");
                                filePath = conf.get("local_tmp_for_remote") + "/" + FileDir + "/" + res[1] + ".xml";
                            }

                            File toAdd = new File(filePath);

                            //Result will be null if the user clicked cancel or closed the dialog w/o OK
                            if (toAdd != null) {
                                try {
                                    DataObject dObject = DataObject.find(FileUtil.toFileObject(toAdd));

                                    dObject.getLookup().lookup(OpenCookie.class).open();
                                    // dont listen for exist listen files
                                    if (existFile(filePath)) {
                                        return;
                                    }
                                    dObject.addPropertyChangeListener(new PropertyChangeListener() {
                                        @Override
                                        public void propertyChange(PropertyChangeEvent evt) {
                                            if (DataObject.PROP_MODIFIED.equals(evt.getPropertyName())) {
                                                //fire a dummy event
                                                if (!Boolean.TRUE.equals(evt.getNewValue())) {

                                                    /*String msg = "Saved to" + evt.toString();
                                                    NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
                                                    DialogDisplayer.getDefault().notify(nd);*/
                                                    TopComponent activeTC = TopComponent.getRegistry().getActivated();
                                                    DataObject dataLookup = activeTC.getLookup().lookup(DataObject.class);
                                                    String filePath = FileUtil.toFile(dataLookup.getPrimaryFile()).getAbsolutePath();

                                                    File userFile = new File(filePath);
                                                    String fileName = userFile.getName();
                                                    fileName = fileName.substring(0, fileName.lastIndexOf("."));

                                                    Global gl_obj = Global.getInstance();

                                                    List<String[]> res_dyna = gl_obj.getDyna();
                                                    String FileDir = "";
                                                    for (String[] s : res_dyna) {

                                                        if (filePath.contains(s[0])) {

                                                            FileDir = s[3];
                                                            break;

                                                        }

                                                    }

                                                    if (conf.isRemote()) {
                                                        boolean res_Upload = SSH.getInstance().uplaodFile(FileDir);
                                                        if (res_Upload) {
                                                            String msg = "file upload Successfully!";
                                                            NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
                                                            DialogDisplayer.getDefault().notify(nd);
                                                        } else {
                                                            String msg = "error in uploading file!";
                                                            NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
                                                            DialogDisplayer.getDefault().notify(nd);
                                                        }
                                                    }

                                                }

                                            }

                                        }
                                    });

                                } catch (DataObjectNotFoundException ex) {
                                    //Exceptions.printStackTrace(ex);
                                    String msg = "Can not find xml file";
                                    NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
                                    DialogDisplayer.getDefault().notify(nd);
                                }
                            }
                        }

                        // for each js file
                        if (node_level == 3) {

                            TreeNode parentInfo = node.getParent();

                            Global gl_obj = Global.getInstance();

                            List<String[]> res_dyna = gl_obj.getDyna();
                            String FileDir = "";
                            for (String[] s : res_dyna) {

                                if (s[1].equals(parentInfo.toString())) {
                                    // get path of dyna in xml forms
                                    FileDir = s[3];
                                    break;
                                }

                            }

                            //myDoubleClick(selRow, selPath);
                            conf = Config.getInstance();
                            String filePath = conf.tmp + "xmlForms/" + FileDir + "/" + nodeInfo.toString() + ".js";
                            if (conf.isRemote()) {
                                filePath = conf.get("local_tmp_for_remote") + FileDir + "/" + nodeInfo.toString() + ".js";
                            }

                            File toAdd = new File(filePath);

                            //Result will be null if the user clicked cancel or closed the dialog w/o OK
                            if (toAdd != null) {
                                try {
                                    DataObject dObject = DataObject.find(FileUtil.toFileObject(toAdd));

                                    dObject.getLookup().lookup(OpenCookie.class).open();
                                    // dont listen for exist listen files
                                    if (existFile(filePath)) {
                                        return;
                                    }
                                    dObject.addPropertyChangeListener(new PropertyChangeListener() {
                                        @Override
                                        public void propertyChange(PropertyChangeEvent evt) {
                                            if (DataObject.PROP_MODIFIED.equals(evt.getPropertyName())) {
                                                //fire a dummy event
                                                if (!Boolean.TRUE.equals(evt.getNewValue())) {

                                                    JTextComponent ed = EditorRegistry.lastFocusedComponent();
                                                    String jsDoc = "";
                                                    try {
                                                        jsDoc = ed.getText();
                                                    } catch (Exception ex) {
                                                        //Exceptions.printStackTrace(ex);
                                                        String msg = "Can not get text from editor";
                                                        NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
                                                        DialogDisplayer.getDefault().notify(nd);
                                                    }

                                                    TopComponent activeTC = TopComponent.getRegistry().getActivated();
                                                    DataObject dataLookup = activeTC.getLookup().lookup(DataObject.class);
                                                    String filePath = FileUtil.toFile(dataLookup.getPrimaryFile()).getAbsolutePath();

                                                    File userFile = new File(filePath);
                                                    String fileName = userFile.getName();
                                                    fileName = fileName.substring(0, fileName.lastIndexOf("."));

                                                    Global gl_obj = Global.getInstance();

                                                    List<String[]> res_dyna = gl_obj.getDyna();
                                                    String FileDir = "";
                                                    for (String[] s : res_dyna) {

                                                        if (filePath.contains(s[0])) {

                                                            FileDir = s[3];
                                                            break;

                                                        }

                                                    }

                                                    String fullPath = conf.getXmlForms() + FileDir + ".xml";
                                                    if (conf.isRemote()) {
                                                        String[] res = FileDir.split("/");
                                                        fullPath = conf.get("local_tmp_for_remote") + FileDir + "/" + res[1] + ".xml";
                                                    }
                                                    try {
                                                        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                                                        DocumentBuilder builder = factory.newDocumentBuilder();
                                                        Document mainDoc = builder.parse(fullPath);

                                                        XPath xPath = XPathFactory.newInstance().newXPath();
                                                        Node startDateNode = (Node) xPath.compile("//dynaForm/" + fileName).evaluate(mainDoc, XPathConstants.NODE);
                                                        Node cdata = mainDoc.createCDATASection(jsDoc);
                                                        startDateNode.setTextContent("");
                                                        startDateNode.appendChild(cdata);

                                                        /*String msg = evt.getPropertyName() + "-" + fileName;
                                                        NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
                                                        DialogDisplayer.getDefault().notify(nd);*/
                                                        // write the content into xml file
                                                        TransformerFactory transformerFactory = TransformerFactory
                                                                .newInstance();
                                                        Transformer transformer = transformerFactory.newTransformer();
                                                        DOMSource source = new DOMSource(mainDoc);
                                                        StreamResult result = new StreamResult(new File(fullPath));
                                                        transformer.transform(source, result);

                                                        if (conf.isRemote()) {
                                                            boolean res_Upload = SSH.getInstance().uplaodFile(FileDir);
                                                            if (res_Upload) {
                                                                String msg = "file upload Successfully!";
                                                                NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
                                                                DialogDisplayer.getDefault().notify(nd);
                                                            } else {
                                                                String msg = "error in uploading file!";
                                                                NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
                                                                DialogDisplayer.getDefault().notify(nd);
                                                            }
                                                        }

                                                    } catch (Exception ex) {
                                                        //Exceptions.printStackTrace(ex);
                                                        String msg = "Can not save to xml form";
                                                        NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
                                                        DialogDisplayer.getDefault().notify(nd);
                                                    }

                                                }

                                            }

                                        }
                                    });

                                } catch (DataObjectNotFoundException ex) {
                                    //Exceptions.printStackTrace(ex);
                                    String msg = "Can not save to xml form";
                                    NotifyDescriptor nd = new NotifyDescriptor.Message(msg, NotifyDescriptor.INFORMATION_MESSAGE);
                                    DialogDisplayer.getDefault().notify(nd);
                                }
                            }
                        }
                    }
                }
            }
        };
        jTree1.addMouseListener(ml);
        jTree1.setModel(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();

        jScrollPane1.setViewportView(jTree1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
        //GoogleActionListener gal = new GoogleActionListener();
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    public javax.swing.JTree getTree() {
        return jTree1;
    }

    private static TreeFilesTopComponent instance;
    List<String[]> res_dyna;
    List<String[]> res_trigger;
    Config conf;

    public void setResDyna(List<String[]> res_dyna) {
        this.res_dyna = res_dyna;
    }

    public void setTrigger(List<String[]> res_trigger) {
        this.res_trigger = res_trigger;
    }

    public boolean existFile(String currFile) {

        if (allFile.contains(currFile)) {
            return true;
        }
        allFile.add(currFile);
        return false;

    }

    List<String> allFile = new ArrayList<String>();

    public static TreeFilesTopComponent getInstance() {
        return instance;
    }

}
