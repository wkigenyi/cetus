/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systems.tech247.pdreditors;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import org.netbeans.spi.actions.AbstractSavable;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.view.OutlineView;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import systems.tech247.dbaccess.DataAccess;

import systems.tech247.hr.Employees;
import systems.tech247.hr.Employment;
import systems.tech247.hr.Nationalities;
import systems.tech247.hr.Tribes;
import systems.tech247.pdr.QueryEmployment;
import systems.tech247.pdr.Utility;
import systems.tech247.util.CapCreatable;
import systems.tech247.util.CapDeletable;
import systems.tech247.util.ReloadableQueryCapability;

/**
 *
 * @author Admin
 */
public class EmploymentHistoryPanel extends javax.swing.JPanel implements LookupListener,ExplorerManager.Provider{
    
    ExplorerManager em = Utility.emEmployeeEmploymentHistory;
    Employees emp;
    DataAccess da = new DataAccess();
    Tribes tribeID;
    Nationalities nationalityID;
    EntityManager entityManager = da.getEntityManager();
    TopComponent empTc = WindowManager.getDefault().findTopComponent("EmployeesTopComponent");
    Lookup.Result<Employees> empRslt = empTc.getLookup().lookupResult(Employees.class);
    TopComponent nationTc = WindowManager.getDefault().findTopComponent("NationsTopComponent");
    Lookup.Result<Nationalities> nationRslt = nationTc.getLookup().lookupResult(Nationalities.class);
    TopComponent tribeTc = WindowManager.getDefault().findTopComponent("TribesTopComponent");
    Lookup.Result<Tribes> tribeRslt = tribeTc.getLookup().lookupResult(Tribes.class);
    /**
     * Creates new form PersonalInfoPanel
     */
    public EmploymentHistoryPanel() {
        initComponents();
        //Start transaction
        OutlineView ov = new OutlineView("Employment History");
        ov.getOutline().setRootVisible(true);
        viewPanel.setLayout(new BorderLayout());
        viewPanel.add(ov);
        empRslt.addLookupListener(this);
        resultChanged(new LookupEvent(empRslt));
        
        nationRslt.addLookupListener(this);
        resultChanged(new LookupEvent(nationRslt));
        
        tribeRslt.addLookupListener(this);
        resultChanged(new LookupEvent(tribeRslt));
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewPanel = new javax.swing.JPanel();

        viewPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout viewPanelLayout = new javax.swing.GroupLayout(viewPanel);
        viewPanel.setLayout(viewPanelLayout);
        viewPanelLayout.setHorizontalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 238, Short.MAX_VALUE)
        );
        viewPanelLayout.setVerticalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void resultChanged(LookupEvent le) {
        Lookup.Result result = (Lookup.Result)le.getSource();
        for (Object e: result.allInstances()){
            if(e instanceof Employees){
                
                emp = (Employees)e;
                
                Utility.loadEmployment(emp);
            }
        }
    }
    
    void modify(){
        if(getLookup().lookup(MySavable.class)==null){
            Utility.editorIC.add(new MySavable());
        }
    }

    
    public Lookup getLookup() {
        TopComponent tc = WindowManager.getDefault().findTopComponent("EmployeeEditorTopComponent");
        return tc.getLookup();
    }

    @Override
    public ExplorerManager getExplorerManager() {
        return em;
    }
    
    private class MySavable extends AbstractSavable{

        public MySavable(){
            register();
        } 
        
        @Override
        protected String findDisplayName() {
            return "Employee";
        }

        @Override
        protected void handleSave() throws IOException {
            
            
        }
        
        EmploymentHistoryPanel pnel(){
            return EmploymentHistoryPanel.this;
        }

        @Override
        public boolean equals(Object o) {
            if(o instanceof MySavable){
                MySavable m = (MySavable)o;
                return pnel() == m.pnel();
            }
            return false;
        }

        @Override
        public int hashCode() {
            return pnel().hashCode();
        }
        
    }
    
    void resetEditor(){
        
    }
    
    void loadItems(){
        em.setRootContext(new RootNode(emp));
    }
    
    private class RootNode extends AbstractNode{
        
        private final InstanceContent instanceContent;
        
        
        
        public RootNode(Employees emp){
            this(new InstanceContent(),emp);
        }
        
        private RootNode (InstanceContent ic, Employees emp){
            super(Children.create(new FactoryItems(new QueryEmployment(emp)), true), new AbstractLookup(ic));
            instanceContent = ic;
            instanceContent.add(emp);
            instanceContent.add(new CapCreatable() {
                @Override
                public void create() {
                    
                }
            });
            setIconBaseWithExtension("systems/tech247/util/icons/settings.png");
            setDisplayName("Add Work History Here");
        }
    
}
    public class FactoryItems extends ChildFactory<Employment>{

        QueryEmployment query;
    
    public FactoryItems(QueryEmployment query){
        this.query = query;
    }
    
    @Override
    protected boolean createKeys(List<Employment> list) {
        //get this ability from the look
        ReloadableQueryCapability r = query.getLookup().lookup(ReloadableQueryCapability.class);
        //Use the ability
        if(r != null){
            try{
                r.reload();
            }catch(Exception ex){
                
            }
        }
        //Populate the list of child entries
        list.addAll(query.getList());
        
        //return true since we are set
        return true;
    }
    
    @Override
    protected Node createNodeForKey(Employment key){
        Node node = new ItemNode(key);
       
        
        return node;
    }
    
    private class ItemNode extends AbstractNode{
        
        private final InstanceContent instanceContent;
        
        public ItemNode(Employment emp){
            this(new InstanceContent(),emp);
        }
        
        private ItemNode (InstanceContent ic, Employment emp){
            super(Children.LEAF, new AbstractLookup(ic));
            instanceContent = ic;
            instanceContent.add(emp);
            
            instanceContent.add(new CapDeletable() {
                @Override
                public void delete() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            
            setIconBaseWithExtension("systems/tech247/util/icons/company.png");
            setDisplayName(emp.getEmployer());
        }
    
}
    }
}