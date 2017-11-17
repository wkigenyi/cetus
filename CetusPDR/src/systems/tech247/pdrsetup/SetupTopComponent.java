/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systems.tech247.pdrsetup;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.explorer.ExplorerUtils;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.ProxyLookup;
import org.openide.windows.WindowManager;
import systems.tech247.hr.Employees;
import systems.tech247.pdr.Utility;
import systems.tech247.pdreditors.PDREditorCompanyInfoPanel;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//systems.tech247.pdrsetup//Setup//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "SetupTopComponent",
        iconBase = "systems/tech247/util/icons/settings.png", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "systems.tech247.setup.SetupTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_SetupAction",
        
        preferredID = "SetupTopComponent"
)
@Messages({
    "CTL_SetupAction=PDR Setup",
    "CTL_SetupTopComponent=PDR Setup",
    "HINT_SetupTopComponent= PDR Setup"
})
public final class SetupTopComponent extends TopComponent implements TreeSelectionListener, LookupListener {

    
    Lookup lookup;
    TopComponent empTc = WindowManager.getDefault().findTopComponent("EmployeesTopComponent");
    Lookup.Result<Employees> empRslt = empTc.getLookup().lookupResult(Employees.class);
    
    JTree tree;
    DefaultMutableTreeNode selectedNode;
    public SetupTopComponent() {
        initComponents();
        setName(Bundle.CTL_SetupTopComponent());
        setToolTipText(Bundle.HINT_SetupTopComponent());
        lookup = new AbstractLookup(Utility.editorPDRIC);
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("System Information");
        panelHolder.setLayout(new BorderLayout());
        tree = new JTree(top);
        createNodes(top);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        treeHolder.setLayout(new BorderLayout());
        treeHolder.add(tree);
        expandAllNodes(tree, 0, tree.getRowCount());
        
        tree.addTreeSelectionListener(this);
        
        tree.setSelectionPath(new TreePath(selectedNode.getPath()));
        
        jTEmployeeName.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Object[] options = {new JButton("Close")};
                DialogDisplayer.getDefault().notify(new DialogDescriptor(empTc, "Search Employees",true, options,null,DialogDescriptor.DEFAULT_ALIGN,null,null));
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                            }
        });
       
        
        empRslt.addLookupListener(this);
        //Associated lookups
        Lookup jdcategories =  ExplorerUtils.createLookup(Utility.pdrJDcategories, getActionMap());
        Lookup jds =  ExplorerUtils.createLookup(Utility.pdrJD, getActionMap());
        Lookup companyAssets =  ExplorerUtils.createLookup(Utility.pdrCompanyAssets, getActionMap());
        Lookup locations =  ExplorerUtils.createLookup(Utility.pdrLocations, getActionMap());
        Lookup countries =  ExplorerUtils.createLookup(Utility.pdrCountries, getActionMap());
        Lookup jobs =  ExplorerUtils.createLookup(Utility.pdrJobs, getActionMap());
        Lookup currencies =  ExplorerUtils.createLookup(Utility.pdrCurrency, getActionMap());
        Lookup departments =  ExplorerUtils.createLookup(Utility.pdrOrganizationUnits, getActionMap());
        Lookup ouTypes =  ExplorerUtils.createLookup(Utility.pdrOrganizationUnitTypes, getActionMap());
        Lookup religions =  ExplorerUtils.createLookup(Utility.pdrReligions, getActionMap());
        Lookup tribes =  ExplorerUtils.createLookup(Utility.pdrTribes, getActionMap());
        Lookup nationalities =  ExplorerUtils.createLookup(Utility.pdrNationalities, getActionMap());
        Lookup banks =  ExplorerUtils.createLookup(Utility.pdrBanks, getActionMap());
        Lookup contactTypes =  ExplorerUtils.createLookup(Utility.pdrContactTypes, getActionMap());
        ProxyLookup mergedLookup = new ProxyLookup(lookup,companyAssets,departments,ouTypes,religions,tribes,nationalities,banks,contactTypes,currencies,jobs,locations,countries,jdcategories,jds);
        associateLookup(mergedLookup);

    }
    
    private void createNodes(DefaultMutableTreeNode node){
        
        DefaultMutableTreeNode category;
        DefaultMutableTreeNode panel;
        
        
        
        category = new DefaultMutableTreeNode("Setup Information");
        node.add(category);
        selectedNode  = new DefaultMutableTreeNode(new PanelInfo("Company Information", new PDREditorCompanyInfoPanel()));
        category.add(selectedNode);
        
        panel = new DefaultMutableTreeNode(new PanelInfo("Organization Unit Types", new PDROUTypePanel()));
        category.add(panel);
        
        panel = new DefaultMutableTreeNode(new PanelInfo("Organization Units", new PDRDepartmentsPanel()));
        category.add(panel);
        
        panel = new DefaultMutableTreeNode(new PanelInfo("Contact Types", new PDRContactTypesPanel()));
        category.add(panel);
        
        
        
        
        panel = new DefaultMutableTreeNode(new PanelInfo("Locations", new PDRLocationsPanel()));
        category.add(panel);
        
        
        
        
        panel = new DefaultMutableTreeNode(new PanelInfo("Company Assets", new PDRCompanyAssetsPanel()));
        category.add(panel);
        
        
        
        panel = new DefaultMutableTreeNode(new PanelInfo("Religions", new PDRReligionsPanel()));
        category.add(panel);
        panel = new DefaultMutableTreeNode(new PanelInfo("Tribes", new PDRTribesPanel()));
        category.add(panel);
        panel = new DefaultMutableTreeNode(new PanelInfo("Nationalities", new PDRNationalityPanel()));
        category.add(panel);
        panel = new DefaultMutableTreeNode(new PanelInfo("Countries", new PDRCountryPanel()));
        category.add(panel);
        panel = new DefaultMutableTreeNode(new PanelInfo("Banks", new PDRBanksPanel()));
        category.add(panel);
        panel = new DefaultMutableTreeNode(new PanelInfo("Currencies", new PDRCurrencyPanel()));
        category.add(panel);
        category = new DefaultMutableTreeNode("Job Positions & Descriptions");
        node.add(category);
        panel = new DefaultMutableTreeNode(new PanelInfo("Job Positions", new PDRPositionsPanel()));
        category.add(panel);
        panel = new DefaultMutableTreeNode(new PanelInfo("Job Description Categories", new PDRJDCategoryPanel()));
        category.add(panel);
        panel = new DefaultMutableTreeNode(new PanelInfo("Job Descriptions", new PDRJDPanel()));
        category.add(panel);
        
        
        
    }

    @Override
    public void resultChanged(LookupEvent le) {
        Lookup.Result result = (Lookup.Result)le.getSource();
        for (Object e: result.allInstances()){
            if(e instanceof Employees){
                jTEmployeeName.setText(((Employees) e).getSurName()+ " "+ ((Employees) e).getOtherNames());
            }
        }
    }
    
    private class PanelInfo{
        String description;
        JPanel panel;
        
        public PanelInfo(String desc, JPanel panel){
            this.description = desc;
            this.panel = panel;
        }
        
        @Override
        public String toString(){
            return description;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTEmployeeName = new javax.swing.JTextField();
        panelHolder = new javax.swing.JPanel();
        treeHolder = new javax.swing.JPanel();

        jTEmployeeName.setBackground(new java.awt.Color(0, 204, 0));
        jTEmployeeName.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jTEmployeeName.setText(org.openide.util.NbBundle.getMessage(SetupTopComponent.class, "SetupTopComponent.jTEmployeeName.text")); // NOI18N
        jTEmployeeName.setToolTipText(org.openide.util.NbBundle.getMessage(SetupTopComponent.class, "SetupTopComponent.jTEmployeeName.toolTipText")); // NOI18N

        panelHolder.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout panelHolderLayout = new javax.swing.GroupLayout(panelHolder);
        panelHolder.setLayout(panelHolderLayout);
        panelHolderLayout.setHorizontalGroup(
            panelHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
        );
        panelHolderLayout.setVerticalGroup(
            panelHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 282, Short.MAX_VALUE)
        );

        treeHolder.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout treeHolderLayout = new javax.swing.GroupLayout(treeHolder);
        treeHolder.setLayout(treeHolderLayout);
        treeHolderLayout.setHorizontalGroup(
            treeHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 131, Short.MAX_VALUE)
        );
        treeHolderLayout.setVerticalGroup(
            treeHolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(treeHolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelHolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(treeHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelHolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jTEmployeeName;
    private javax.swing.JPanel panelHolder;
    private javax.swing.JPanel treeHolder;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        resultChanged(new LookupEvent(empRslt));
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

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
        if(node == null){
            //Do nothing 
        }
        
        Object nodeInfo = node.getUserObject();
        if(node.isLeaf()){
            PanelInfo panel = (PanelInfo)nodeInfo;
            panelHolder.removeAll();
            panelHolder.add(panel.panel);
            panelHolder.setPreferredSize(panel.panel.getPreferredSize());
            panelHolder.revalidate();
            
            repaint();
           
        }else{
            panelHolder.removeAll();
            panelHolder.revalidate();
            repaint();
            
        }
  
    }
    private void expandAllNodes(JTree tree, int startingIndex, int rowCount){
    for(int i=startingIndex;i<rowCount;++i){
        tree.expandRow(i);
    }

    if(tree.getRowCount()!=rowCount){
        expandAllNodes(tree, rowCount, tree.getRowCount());
    }
}
}
