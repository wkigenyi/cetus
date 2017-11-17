/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systems.tech247.pdrsetup;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.persistence.EntityManager;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.awt.StatusDisplayer;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.view.OutlineView;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.Lookup;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import systems.tech247.dbaccess.DataAccess;
import systems.tech247.hr.Nationalities;
import systems.tech247.pdr.QueryNation;

import systems.tech247.pdr.Utility;
import systems.tech247.pdreditors.PDRNationalityEditor;
import systems.tech247.util.CapCreatable;
import systems.tech247.util.CapDeletable;
import systems.tech247.util.CapEditable;
import systems.tech247.util.ReloadableQueryCapability;

/**
 *
 * @author Admin
 */
public class PDRNationalityPanel extends javax.swing.JPanel implements ExplorerManager.Provider{
    
    ExplorerManager em = Utility.pdrNationalities;
    
    
    DataAccess da = new DataAccess();
    
    QueryNation query = new QueryNation();
    String sqlString;
    String searchString;
    
    EntityManager entityManager = da.getEntityManager();
    
    
    /**
     * Creates new form PersonalInfoPanel
     */
    public PDRNationalityPanel() {
        initComponents();
        //Start transaction
        OutlineView ov = new OutlineView("Nationalities");
        ov.getOutline().setRootVisible(true);
        viewPanel.setLayout(new BorderLayout());
        viewPanel.add(ov);
        
        sqlString ="SELECT r from Nationalities r";
        
        
        Utility.loadNationalities(sqlString);
        
        
        jtsearch.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                searchString = jtsearch.getText();
                sqlString ="SELECT r from Nationalities r WHERE r.nationality LIKE '%"+searchString+"%'";
                query.setSqlString(sqlString);
                 Utility.loadNationalities(sqlString);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
        
        
        
        
        
        
        
        
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
        jLabel1 = new javax.swing.JLabel();
        jtsearch = new javax.swing.JTextField();

        viewPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout viewPanelLayout = new javax.swing.GroupLayout(viewPanel);
        viewPanel.setLayout(viewPanelLayout);
        viewPanelLayout.setHorizontalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
        );
        viewPanelLayout.setVerticalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 393, Short.MAX_VALUE)
        );

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(PDRNationalityPanel.class, "PDRNationalityPanel.jLabel1.text")); // NOI18N

        jtsearch.setBackground(new java.awt.Color(51, 255, 255));
        jtsearch.setText(org.openide.util.NbBundle.getMessage(PDRNationalityPanel.class, "PDRNationalityPanel.jtsearch.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtsearch)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jtsearch;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables

      
    

    
    public Lookup getLookup() {
        TopComponent tc = WindowManager.getDefault().findTopComponent("EmployeeEditorTopComponent");
        return tc.getLookup();
    }

    @Override
    public ExplorerManager getExplorerManager() {
        return em;
    }
    
    
    
    void resetEditor(){
        
        
    }
    
    
    
    
    public class FactoryItems extends ChildFactory<Nationalities>{

        QueryNation query;
    
    public FactoryItems(QueryNation query){
        this.query = query;
    }
    
    @Override
    protected boolean createKeys(List<Nationalities> list) {
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
    protected Node createNodeForKey(Nationalities key){
        Node node = new ItemNode(key);
       
        
        return node;
    }
    
    private class ItemNode extends AbstractNode{
        
        private final InstanceContent instanceContent;
        
        public ItemNode(Nationalities emp){
            this(new InstanceContent(),emp);
        }
        
        private ItemNode (InstanceContent ic, final Nationalities emp){
            super(Children.LEAF, new AbstractLookup(ic));
            instanceContent = ic;
            instanceContent.add(emp);
            
            instanceContent.add(new CapEditable() {
                @Override
                public void edit() {
                    NotifyDescriptor nd = new NotifyDescriptor(new PDRNationalityEditor(emp), "Edit Nationality", NotifyDescriptor.OK_CANCEL_OPTION,
                NotifyDescriptor.PLAIN_MESSAGE, new Object[]{}, null);
        //nd.setNoDefaultClose(true);  
        DialogDisplayer.getDefault().notifyLater(nd);
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
            
            
            instanceContent.add(new CapDeletable() {
                @Override
                public void delete() {
                    StatusDisplayer.getDefault().setStatusText("We are not deleting these days");
                }
            });
            
            
            setIconBaseWithExtension("systems/tech247/util/icons/settings.png");
            setDisplayName(emp.getNationality());
            
            
        }
        
        
        
        
    
}
    }
}
