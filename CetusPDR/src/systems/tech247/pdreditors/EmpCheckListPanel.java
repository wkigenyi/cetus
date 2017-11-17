/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systems.tech247.pdreditors;

import java.awt.Component;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import org.netbeans.spi.actions.AbstractSavable;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import systems.tech247.dbaccess.DataAccess;
import systems.tech247.hr.Employees;

import systems.tech247.pdr.Utility;

/**
 *
 * @author Admin
 */
public final class EmpCheckListPanel extends javax.swing.JPanel implements LookupListener{

    Employees emp;
    DataAccess da = new DataAccess();
    
    EntityManager entityManager = DataAccess.getEntityManager();
    TopComponent empTc = WindowManager.getDefault().findTopComponent("EmployeesTopComponent");
    Lookup.Result<Employees> empRslt = empTc.getLookup().lookupResult(Employees.class);
    
    /* Updatables*/
    
    boolean applicationForm = false;
    boolean bankDetails = false;
    boolean cvCopy = false;
    boolean employeeLetter = false;
    boolean handbook =false;
    boolean idCopy = false;
    boolean nssfCopy = false;
    boolean orientation = false;
    boolean pinCopy = false;
    boolean referees = false;
    boolean testimonials = false;
    boolean training = false;
    boolean terms = false;
    boolean jd =false;
    
    
    /**
     * Creates new form PersonalInfoPanel
     */
    public EmpCheckListPanel() {
        initComponents();
        //Start transaction
        
        empRslt.addLookupListener(this);
        resultChanged(new LookupEvent(empRslt));
        
        disableInput();
        
        
        
        
    }
    
    void disableInput(){
        boolean shl = null != emp;
        Component[] comps = getComponents();
        for(Component c: comps){
            if(!(c instanceof JLabel)){
                c.setEnabled(shl);
            } else {
                
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbCVCopy = new javax.swing.JCheckBox();
        cbApplicationForm = new javax.swing.JCheckBox();
        cbTestimonials = new javax.swing.JCheckBox();
        cbHandBook = new javax.swing.JCheckBox();
        cbEmploymentLetter = new javax.swing.JCheckBox();
        cbIDCopy = new javax.swing.JCheckBox();
        cbNSSFCopy = new javax.swing.JCheckBox();
        cbPINCopy = new javax.swing.JCheckBox();
        cbOrientation = new javax.swing.JCheckBox();
        cbReferees = new javax.swing.JCheckBox();
        cbTaskBreakDown = new javax.swing.JCheckBox();
        cbTraining = new javax.swing.JCheckBox();
        cbBankDetails = new javax.swing.JCheckBox();
        cbSignedTA = new javax.swing.JCheckBox();

        org.openide.awt.Mnemonics.setLocalizedText(cbCVCopy, org.openide.util.NbBundle.getMessage(EmpCheckListPanel.class, "EmpCheckListPanel.cbCVCopy.text")); // NOI18N
        cbCVCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCVCopyActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cbApplicationForm, org.openide.util.NbBundle.getMessage(EmpCheckListPanel.class, "EmpCheckListPanel.cbApplicationForm.text")); // NOI18N
        cbApplicationForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbApplicationFormActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cbTestimonials, org.openide.util.NbBundle.getMessage(EmpCheckListPanel.class, "EmpCheckListPanel.cbTestimonials.text")); // NOI18N
        cbTestimonials.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTestimonialsActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cbHandBook, org.openide.util.NbBundle.getMessage(EmpCheckListPanel.class, "EmpCheckListPanel.cbHandBook.text")); // NOI18N
        cbHandBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHandBookActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cbEmploymentLetter, org.openide.util.NbBundle.getMessage(EmpCheckListPanel.class, "EmpCheckListPanel.cbEmploymentLetter.text")); // NOI18N
        cbEmploymentLetter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEmploymentLetterActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cbIDCopy, org.openide.util.NbBundle.getMessage(EmpCheckListPanel.class, "EmpCheckListPanel.cbIDCopy.text")); // NOI18N
        cbIDCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIDCopyActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cbNSSFCopy, org.openide.util.NbBundle.getMessage(EmpCheckListPanel.class, "EmpCheckListPanel.cbNSSFCopy.text")); // NOI18N
        cbNSSFCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNSSFCopyActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cbPINCopy, org.openide.util.NbBundle.getMessage(EmpCheckListPanel.class, "EmpCheckListPanel.cbPINCopy.text")); // NOI18N
        cbPINCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPINCopyActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cbOrientation, org.openide.util.NbBundle.getMessage(EmpCheckListPanel.class, "EmpCheckListPanel.cbOrientation.text")); // NOI18N
        cbOrientation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOrientationActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cbReferees, org.openide.util.NbBundle.getMessage(EmpCheckListPanel.class, "EmpCheckListPanel.cbReferees.text")); // NOI18N
        cbReferees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRefereesActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cbTaskBreakDown, org.openide.util.NbBundle.getMessage(EmpCheckListPanel.class, "EmpCheckListPanel.cbTaskBreakDown.text")); // NOI18N
        cbTaskBreakDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTaskBreakDownActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cbTraining, org.openide.util.NbBundle.getMessage(EmpCheckListPanel.class, "EmpCheckListPanel.cbTraining.text")); // NOI18N
        cbTraining.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTrainingActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cbBankDetails, org.openide.util.NbBundle.getMessage(EmpCheckListPanel.class, "EmpCheckListPanel.cbBankDetails.text")); // NOI18N
        cbBankDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBankDetailsActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cbSignedTA, org.openide.util.NbBundle.getMessage(EmpCheckListPanel.class, "EmpCheckListPanel.cbSignedTA.text")); // NOI18N
        cbSignedTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSignedTAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbCVCopy)
                    .addComponent(cbApplicationForm)
                    .addComponent(cbTestimonials)
                    .addComponent(cbHandBook)
                    .addComponent(cbEmploymentLetter)
                    .addComponent(cbIDCopy)
                    .addComponent(cbNSSFCopy))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPINCopy)
                    .addComponent(cbOrientation)
                    .addComponent(cbReferees)
                    .addComponent(cbTaskBreakDown)
                    .addComponent(cbTraining)
                    .addComponent(cbBankDetails)
                    .addComponent(cbSignedTA))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbPINCopy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbOrientation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbReferees)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTaskBreakDown)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTraining)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbBankDetails)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSignedTA))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbCVCopy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbApplicationForm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTestimonials)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbHandBook)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbEmploymentLetter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbIDCopy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbNSSFCopy)))
                .addContainerGap(277, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbApplicationFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbApplicationFormActionPerformed
        applicationForm = cbApplicationForm.isSelected();
        modify();
    }//GEN-LAST:event_cbApplicationFormActionPerformed

    private void cbHandBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHandBookActionPerformed
        handbook = cbHandBook.isSelected();
        modify();
    }//GEN-LAST:event_cbHandBookActionPerformed

    private void cbPINCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPINCopyActionPerformed
        pinCopy = cbPINCopy.isSelected();
        modify();
    }//GEN-LAST:event_cbPINCopyActionPerformed

    private void cbTrainingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTrainingActionPerformed
        training = cbTraining.isSelected();
        modify();
    }//GEN-LAST:event_cbTrainingActionPerformed

    private void cbSignedTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSignedTAActionPerformed
        terms = cbSignedTA.isSelected();
        modify();
    }//GEN-LAST:event_cbSignedTAActionPerformed

    private void cbCVCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCVCopyActionPerformed
        cvCopy = cbCVCopy.isSelected();
        modify();
    }//GEN-LAST:event_cbCVCopyActionPerformed

    private void cbOrientationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOrientationActionPerformed
        orientation = cbOrientation.isSelected();
        modify();
    }//GEN-LAST:event_cbOrientationActionPerformed

    private void cbTestimonialsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTestimonialsActionPerformed
        testimonials = cbTestimonials.isSelected();
        modify();
    }//GEN-LAST:event_cbTestimonialsActionPerformed

    private void cbRefereesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRefereesActionPerformed
        referees = cbReferees.isSelected();
        modify();
    }//GEN-LAST:event_cbRefereesActionPerformed

    private void cbTaskBreakDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTaskBreakDownActionPerformed
        jd = cbTaskBreakDown.isSelected();
        modify();
    }//GEN-LAST:event_cbTaskBreakDownActionPerformed

    private void cbEmploymentLetterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEmploymentLetterActionPerformed
        employeeLetter = cbEmploymentLetter.isSelected();
        modify();
    }//GEN-LAST:event_cbEmploymentLetterActionPerformed

    private void cbIDCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIDCopyActionPerformed
        idCopy = cbIDCopy.isSelected();
        modify();
    }//GEN-LAST:event_cbIDCopyActionPerformed

    private void cbBankDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBankDetailsActionPerformed
        bankDetails = cbBankDetails.isSelected();
        modify();
    }//GEN-LAST:event_cbBankDetailsActionPerformed

    private void cbNSSFCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNSSFCopyActionPerformed
        nssfCopy = cbNSSFCopy.isSelected();
        modify();
    }//GEN-LAST:event_cbNSSFCopyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbApplicationForm;
    private javax.swing.JCheckBox cbBankDetails;
    private javax.swing.JCheckBox cbCVCopy;
    private javax.swing.JCheckBox cbEmploymentLetter;
    private javax.swing.JCheckBox cbHandBook;
    private javax.swing.JCheckBox cbIDCopy;
    private javax.swing.JCheckBox cbNSSFCopy;
    private javax.swing.JCheckBox cbOrientation;
    private javax.swing.JCheckBox cbPINCopy;
    private javax.swing.JCheckBox cbReferees;
    private javax.swing.JCheckBox cbSignedTA;
    private javax.swing.JCheckBox cbTaskBreakDown;
    private javax.swing.JCheckBox cbTestimonials;
    private javax.swing.JCheckBox cbTraining;
    // End of variables declaration//GEN-END:variables

    @Override
    public void resultChanged(LookupEvent le) {
        Lookup.Result<Employees> result = (Lookup.Result<Employees>)le.getSource();
        for (Employees e: result.allInstances()){
            emp = e;
            
            disableInput();
            
            cbApplicationForm.setSelected(e.getApplicationForm());
            applicationForm = e.getApplicationForm();
            cbBankDetails.setSelected(e.getBankDetailsForm());
            bankDetails = e.getBankDetailsForm();
            cbCVCopy.setSelected(e.getCVCopy());
            cvCopy = e.getCVCopy();
            cbEmploymentLetter.setSelected(e.getSignedAppointmentLetter());
            employeeLetter = e.getSignedAppointmentLetter();
            cbHandBook.setSelected(e.getEmployeeHandbook());
            handbook = e.getEmployeeHandbook();
            cbIDCopy.setSelected(e.getIDCardCopy());
            idCopy = e.getIDCardCopy();
            cbNSSFCopy.setSelected(e.getNSSFCopy());
            nssfCopy = e.getNSSFCopy();
            cbTaskBreakDown.setSelected(e.getJobDescription());
            jd = e.getJobDescription();
            cbOrientation.setSelected(e.getOrientation());
            orientation = e.getOrientation();
            cbPINCopy.setSelected(e.getPINCopy());
            pinCopy = e.getPINCopy();
            cbReferees.setSelected(e.getRefereesCheck());
            referees = e.getRefereesCheck();
            cbTestimonials.setSelected(e.getTestimonials());
            testimonials = e.getTestimonials();
            try{
            cbTraining.setSelected(e.getTrainingAchieved());
            training = e.getTrainingAchieved();
            }catch(NullPointerException exp){
                
            }
            cbSignedTA.setSelected(e.getSignedTermsAndConditions());
            terms = e.getSignedTermsAndConditions();
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
    
    private class MySavable extends AbstractSavable{

        public MySavable(){
            register();
        } 
        
        @Override
        protected String findDisplayName() {
            return "Employee Info";
        }

        @Override
        protected void handleSave() throws IOException {
            
            Utility.editorIC.remove(this);
            
            entityManager.getTransaction().begin();
            Employees e = entityManager.find(Employees.class, emp.getEmployeeID());
            e.setApplicationForm(applicationForm);
            e.setBankDetailsForm(bankDetails);
            e.setCVCopy(cvCopy);
            e.setSignedAppointmentLetter(employeeLetter);
            e.setEmployeeHandbook(handbook);
            e.setIDCardCopy(idCopy);
            e.setNSSFCopy(nssfCopy);
            e.setOrientation(orientation);
            e.setPINCopy(pinCopy);
            e.setRefereesCheck(referees);
            e.setTestimonials(testimonials);
            e.setTrainingAchieved(training);
            e.setSignedTermsAndConditions(orientation);
            e.setJobDescription(jd);
            
            
            entityManager.getTransaction().commit();
            
        }
        
        EmpCheckListPanel pnel(){
            return EmpCheckListPanel.this;
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
    
    
}
