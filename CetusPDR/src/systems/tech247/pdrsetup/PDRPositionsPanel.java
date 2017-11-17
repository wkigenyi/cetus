/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systems.tech247.pdrsetup;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.persistence.EntityManager;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.view.OutlineView;
import org.openide.util.Lookup;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import systems.tech247.dbaccess.DataAccess;
import systems.tech247.hr.CompanyAssets;
import systems.tech247.pdr.QueryPosition;
import systems.tech247.pdr.Utility;

/**
 *
 * @author Admin
 */
public class PDRPositionsPanel extends javax.swing.JPanel implements ExplorerManager.Provider{
    
    ExplorerManager em = Utility.pdrJobs;
    CompanyAssets asset = null;
    
    DataAccess da = new DataAccess();
    
    QueryPosition query = new QueryPosition();
    String sqlString;
    String searchString;
    
    EntityManager entityManager = da.getEntityManager();
    
    
    /**
     * Creates new form PersonalInfoPanel
     */
    public PDRPositionsPanel() {
        initComponents();
        //Start transaction
        OutlineView ov = new OutlineView("Job Positions");
        ov.getOutline().setRootVisible(true);
        viewPanel.setLayout(new BorderLayout());
        viewPanel.add(ov);
        
        sqlString ="SELECT r from JobPositions r";
        Utility.loadJobPositions(sqlString);
        
            
        
       
        
        jTSearchDepartments.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                searchString = jTSearchDepartments.getText();
               sqlString ="SELECT r FROM JobPositions r WHERE r.positionName LIKE '%"+searchString+"%'";
              Utility.loadJobPositions(sqlString);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                searchString = jTSearchDepartments.getText();
               sqlString ="SELECT r FROM JobPositions r WHERE r.positionName LIKE '%"+searchString+"%'";
              Utility.loadJobPositions(sqlString);
               
            }

            @Override
            public void keyReleased(KeyEvent e) {
                searchString = jTSearchDepartments.getText();
               sqlString ="SELECT r FROM JobPositions r WHERE r.positionName LIKE '%"+searchString+"%'";
              Utility.loadJobPositions(sqlString);
               
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
        jTSearchDepartments = new javax.swing.JTextField();

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

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(PDRPositionsPanel.class, "PDRPositionsPanel.jLabel1.text")); // NOI18N

        jTSearchDepartments.setBackground(new java.awt.Color(51, 255, 255));
        jTSearchDepartments.setText(org.openide.util.NbBundle.getMessage(PDRPositionsPanel.class, "PDRPositionsPanel.jTSearchDepartments.text")); // NOI18N

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
                        .addComponent(jTSearchDepartments)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTSearchDepartments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTSearchDepartments;
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
    
    
    
    
    
    
    
}
