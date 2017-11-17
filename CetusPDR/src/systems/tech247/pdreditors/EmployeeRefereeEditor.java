/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systems.tech247.pdreditors;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.openide.awt.StatusDisplayer;
import org.openide.util.Lookup;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import systems.tech247.dbaccess.DataAccess;
import systems.tech247.hr.Employees;
import systems.tech247.hr.Ref;
import systems.tech247.pdr.Utility;


/**
 *
 * @author Admin
 */
public class EmployeeRefereeEditor extends javax.swing.JPanel{

    
    
    DataAccess da = new DataAccess();
    Ref contact;
    Employees employeeID;
    
    
    //Updatables
    String refereeName = null;
    String email = null;
    String mobile = null;
    String comments = null;
    String address = null;
    EntityManager entityManager = da.getEntityManager();
   
    
    
   
    /**
     * Creates new form PersonalInfoPanel
     */
    public EmployeeRefereeEditor(Ref contact){
        this(contact.getEmployeeId(),contact);
    }
    
    public EmployeeRefereeEditor(Employees emp){
        this(emp,null);
    }
    
    
 public EmployeeRefereeEditor(Employees empID,Ref acc) {
        initComponents();
        //Start transaction
        contact = acc;
        
        if(acc != null){
            jtNames.setText(contact.getNames());
            jtMobile.setText(contact.getMNo());
            jtAddress.setText(contact.getAddress());
            jtEmail.setText(contact.getEMail());
            jtComment.setText(contact.getComments());
          
        }
        
        
       
        
        employeeID = empID;
        jtNames.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                refereeName = jtNames.getText();
                modify();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                refereeName = jtNames.getText();
                modify();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                refereeName = jtNames.getText();
                modify();
            }
        });
        
        jtMobile.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                mobile = jtMobile.getText();
                modify();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                mobile = jtMobile.getText();
                modify();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                mobile = jtMobile.getText();
                modify();
            }
        });
        
        jtEmail.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                email = jtEmail.getText();
                modify();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                email = jtEmail.getText();
                modify();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                email = jtEmail.getText();
                modify();
            }
        });
        
        jtComment.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                comments = jtComment.getText();
                modify();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                comments = jtComment.getText();
                modify();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                comments = jtComment.getText();
                modify();
            }
        });
        
        jtAddress.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                address = jtAddress.getText();
                modify();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                address = jtAddress.getText();
                modify();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                address = jtAddress.getText();
                modify();
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

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtMobile = new javax.swing.JTextField();
        jtNames = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAddress = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtComment = new javax.swing.JTextArea();
        jbSave = new javax.swing.JButton();

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(EmployeeRefereeEditor.class, "EmployeeRefereeEditor.jLabel3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(EmployeeRefereeEditor.class, "EmployeeRefereeEditor.jLabel1.text")); // NOI18N

        jtMobile.setText(org.openide.util.NbBundle.getMessage(EmployeeRefereeEditor.class, "EmployeeRefereeEditor.jtMobile.text")); // NOI18N

        jtNames.setText(org.openide.util.NbBundle.getMessage(EmployeeRefereeEditor.class, "EmployeeRefereeEditor.jtNames.text")); // NOI18N

        jtAddress.setColumns(20);
        jtAddress.setRows(5);
        jScrollPane1.setViewportView(jtAddress);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(EmployeeRefereeEditor.class, "EmployeeRefereeEditor.jLabel2.text")); // NOI18N

        jtEmail.setText(org.openide.util.NbBundle.getMessage(EmployeeRefereeEditor.class, "EmployeeRefereeEditor.jtEmail.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(EmployeeRefereeEditor.class, "EmployeeRefereeEditor.jLabel4.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(EmployeeRefereeEditor.class, "EmployeeRefereeEditor.jLabel5.text")); // NOI18N

        jtComment.setColumns(20);
        jtComment.setRows(5);
        jScrollPane2.setViewportView(jtComment);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtNames, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtMobile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jtEmail, jtMobile, jtNames});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                .addGap(13, 13, 13)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addContainerGap())
        );

        org.openide.awt.Mnemonics.setLocalizedText(jbSave, org.openide.util.NbBundle.getMessage(EmployeeRefereeEditor.class, "EmployeeRefereeEditor.jbSave.text")); // NOI18N
        jbSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSave, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbSave)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSaveActionPerformed
        entityManager.getTransaction().begin();    
        
        if(contact == null){ //Add New Referee
            String insertSQL = "INSERT INTO [dbo].[Ref]\n" +
"           ([employee_id]\n" +
"           ,[Names]\n" +
"           ,[MNo]\n" +
"           ,[Address]\n" +
"           ,[Comments]\n" +                    
"           ,[Email])\n" +
"     VALUES\n" +
"           (?,?,?,?,?,?)";
            Query query = entityManager.createNativeQuery(insertSQL);
            query.setParameter(1, employeeID.getEmployeeID());
            query.setParameter(2, refereeName);
            query.setParameter(3, mobile);
            query.setParameter(4, address);
            query.setParameter(5, comments);
            query.setParameter(6, email);
                       
            query.executeUpdate();
            entityManager.getTransaction().commit(); 
            
            resetEditor();
            StatusDisplayer.getDefault().setStatusText("Contact Added");
            
            Utility.loadReferees(employeeID);
            
        }else{
            
            Ref eba = entityManager.find(Ref.class, contact.getId());
            
            
            
            if(null != refereeName){
                eba.setNames(email);
            }
            
            if(null != comments){
                eba.setComments(comments);
            }
            
            if(null != email){
                eba.setEMail(email);
            }
            
            if(null != mobile){
                eba.setMNo(mobile);
            }
            
            if(null != address){
                eba.setAddress(address);
            }
            

            
            entityManager.getTransaction().commit();
            
            StatusDisplayer.getDefault().setStatusText("Referee Saved");
            
            Utility.loadReferees(employeeID);
            resetEditor();
        }
        

    }//GEN-LAST:event_jbSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbSave;
    private javax.swing.JTextArea jtAddress;
    private javax.swing.JTextArea jtComment;
    private javax.swing.JTextField jtEmail;
    private javax.swing.JTextField jtMobile;
    private javax.swing.JTextField jtNames;
    // End of variables declaration//GEN-END:variables


    
    
    void modify(){
        
                jbSave.setEnabled(true);
            
        
    }

    
    public Lookup getLookup() {
        TopComponent tc = WindowManager.getDefault().findTopComponent("EmployeeEditorTopComponent");
        return tc.getLookup();
    }
    
    
    
    void resetEditor(){
        jtNames.setText("");
        jtMobile.setText("");
        jtAddress.setText("");
        jtEmail.setText("");
        jtComment.setText("");
        mobile = null;
        comments = null;
        refereeName = null;
        address = null;
        email = null;
    }
    
    


}
