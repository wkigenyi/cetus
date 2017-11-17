/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systems.tech247.view;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.ExplorerUtils;
import org.openide.explorer.view.OutlineView;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;


/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//systems.tech247.view//Employees//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "EmployeesTopComponent",
        iconBase = "systems/tech247/util/icons/person.png",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "explorer", openAtStartup = false)
@ActionID(category = "Window", id = "systems.tech247.view.EmployeesTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_EmployeesAction",
        preferredID = "EmployeesTopComponent"
)
@Messages({
    "CTL_EmployeesAction=Employees",
    "CTL_EmployeesTopComponent=Employees Window",
    "HINT_EmployeesTopComponent=This is a Employees window"
})
public final class EmployeesTopComponent extends TopComponent implements ExplorerManager.Provider {
    
    ExplorerManager em = new ExplorerManager();
    Boolean disengaged = false;
    String searchString = "";
    QueryEmployee query = new QueryEmployee();
    public EmployeesTopComponent() {
        initComponents();
        setName(Bundle.CTL_EmployeesTopComponent());
        setToolTipText(Bundle.HINT_EmployeesTopComponent());
        OutlineView ov = new OutlineView("Employees");
        ov.getOutline().setRootVisible(false);
        viewPanel.setLayout(new BorderLayout());
        viewPanel.add(ov);
        associateLookup(ExplorerUtils.createLookup(em, getActionMap()));
        
        jtSearchEmployee.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                searchString = jtSearchEmployee.getText();
                
                String sqlString = "SELECT e FROM Employees e WHERE (e.surName LIKE  '%"+searchString+"%' OR e.otherNames LIKE  '%"+searchString+"%' OR e.empCode LIKE  '%"+searchString+"%') AND e.isDisengaged =  '"+disengaged+"'  " ;
                query.setSqlString(sqlString);
                loadItems(query);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                searchString = jtSearchEmployee.getText();
                
                String sqlString = "SELECT e FROM Employees e WHERE (e.surName LIKE  '%"+searchString+"%' OR e.otherNames LIKE  '%"+searchString+"%' OR e.empCode LIKE  '%"+searchString+"%') AND e.isDisengaged =  '"+disengaged+"'  " ;
                query.setSqlString(sqlString);
                loadItems(query);
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                searchString = jtSearchEmployee.getText();
                
                String sqlString = "SELECT e FROM Employees e WHERE (e.surName LIKE  '%"+searchString+"%' OR e.otherNames LIKE  '%"+searchString+"%' OR e.empCode LIKE  '%"+searchString+"%') AND e.isDisengaged =  '"+disengaged+"'  " ;
                query.setSqlString(sqlString);
                loadItems(query);
                
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtSearchEmployee = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbDisengaged = new javax.swing.JCheckBox();
        viewPanel = new javax.swing.JPanel();

        jtSearchEmployee.setBackground(new java.awt.Color(51, 255, 255));
        jtSearchEmployee.setText(org.openide.util.NbBundle.getMessage(EmployeesTopComponent.class, "EmployeesTopComponent.jtSearchEmployee.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(EmployeesTopComponent.class, "EmployeesTopComponent.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(cbDisengaged, org.openide.util.NbBundle.getMessage(EmployeesTopComponent.class, "EmployeesTopComponent.cbDisengaged.text")); // NOI18N
        cbDisengaged.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDisengagedActionPerformed(evt);
            }
        });

        viewPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout viewPanelLayout = new javax.swing.GroupLayout(viewPanel);
        viewPanel.setLayout(viewPanelLayout);
        viewPanelLayout.setHorizontalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        viewPanelLayout.setVerticalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 248, Short.MAX_VALUE)
        );

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtSearchEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbDisengaged)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtSearchEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cbDisengaged))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbDisengagedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDisengagedActionPerformed
        disengaged = cbDisengaged.isSelected();
        searchString = jtSearchEmployee.getText();
                
                String sqlString = "SELECT e FROM Employees e WHERE (e.surName LIKE  '%"+searchString+"%' OR e.otherNames LIKE  '%"+searchString+"%' OR e.empCode LIKE  '%"+searchString+"%') AND e.isDisengaged =  '"+disengaged+"'  " ;
                query.setSqlString(sqlString);
                loadItems(query);
    }//GEN-LAST:event_cbDisengagedActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbDisengaged;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jtSearchEmployee;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
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
    public ExplorerManager getExplorerManager() {
        return em;
    }
    
    void loadItems(QueryEmployee query){
        em.setRootContext(new AbstractNode(Children.create(new FactoryEmployees(query), true)));
    }
    
    
  }
