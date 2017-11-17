/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systems.tech247.pdreditors;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JButton;
import org.netbeans.spi.actions.AbstractSavable;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.awt.StatusDisplayer;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import systems.tech247.dbaccess.DataAccess;
import systems.tech247.hr.Employees;

import systems.tech247.hr.Nationalities;
import systems.tech247.hr.Religions;
import systems.tech247.hr.Tribes;
import systems.tech247.pdr.Utility;
import systems.tech247.util.Gender;
import systems.tech247.util.Marital;

/**
 *
 * @author Admin
 */
public class PDREditorCompanyInfoPanel extends javax.swing.JPanel implements LookupListener{

    Employees emp;
    DataAccess da = new DataAccess();
    Boolean edit =false;
    
    //Updatables
    String fname = null;
    String lname = null;
    Short genderID = null;
    Tribes tribeID = null;
    Short maritalStatusID =null;
    Nationalities nationalityID =null;
    Religions religionID = null;
    String passportNumber = null;
    String nationalID = null;
    String nssfNumber = null;
    Date dob = null;
    
    EntityManager entityManager = da.getEntityManager();
    TopComponent empTc = WindowManager.getDefault().findTopComponent("EmployeesTopComponent");
    Lookup.Result<Employees> empRslt = empTc.getLookup().lookupResult(Employees.class);
    TopComponent nationTc = WindowManager.getDefault().findTopComponent("NationsTopComponent");
    Lookup.Result<Nationalities> nationRslt = nationTc.getLookup().lookupResult(Nationalities.class);
    TopComponent tribeTc = WindowManager.getDefault().findTopComponent("TribesTopComponent");
    Lookup.Result<Tribes> tribeRslt = tribeTc.getLookup().lookupResult(Tribes.class);
    TopComponent genderTc = WindowManager.getDefault().findTopComponent("GenderTopComponent");
    Lookup.Result<Gender> genderRslt = genderTc.getLookup().lookupResult(Gender.class);
    TopComponent maritalTc = WindowManager.getDefault().findTopComponent("MaritalTopComponent");
    Lookup.Result<Marital> maritalRslt = maritalTc.getLookup().lookupResult(Marital.class);
    TopComponent religionTc = WindowManager.getDefault().findTopComponent("ReligionsTopComponent");
    Lookup.Result<Religions> religionRslt = religionTc.getLookup().lookupResult(Religions.class);
    /**
     * Creates new form PersonalInfoPanel
     */
    public PDREditorCompanyInfoPanel() {
        initComponents();
        //Start transaction
        
        religionRslt.addLookupListener(this);
        resultChanged(new LookupEvent(religionRslt));
        empRslt.addLookupListener(this);
        resultChanged(new LookupEvent(empRslt));
        
        genderRslt.addLookupListener(this);
        resultChanged(new LookupEvent(genderRslt));
        
        maritalRslt.addLookupListener(this);
        resultChanged(new LookupEvent(maritalRslt));
        
        nationRslt.addLookupListener(this);
        resultChanged(new LookupEvent(nationRslt));
        
        tribeRslt.addLookupListener(this);
        resultChanged(new LookupEvent(tribeRslt));
        
        jtNationality.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Object[] options = {new JButton("Close")};
                DialogDisplayer.getDefault().notify(new DialogDescriptor(nationTc, "Search Nations",true, options,null,DialogDescriptor.DEFAULT_ALIGN,null,null));
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
        
        jtTribe.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Object[] options = {new JButton("Close")};
                DialogDisplayer.getDefault().notify(new DialogDescriptor(tribeTc, "Select A Tribe",true, options,null,DialogDescriptor.DEFAULT_ALIGN,null,null));
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
        
        
        jtFirstName.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                edit = true;
                fname = jtFirstName.getText();
                
                modify();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                edit = true;
                fname = jtFirstName.getText();
                
                modify();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                edit = true;
                fname = jtFirstName.getText();
                
                modify();
            }
        });
        
        jtLastName.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                edit = true;
                lname = jtLastName.getText();
                modify();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                edit = true;
                lname = jtLastName.getText();
                modify();
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                edit = true;
                lname = jtLastName.getText();
                modify();
            }
        });
        
        jtPassportNumber.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                passportNumber = jtPassportNumber.getText();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
        
        jtPassportNumber.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                passportNumber = jtPassportNumber.getText();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
        
        
        jtNSSFNo.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                nssfNumber = jtNSSFNo.getText();
                modify();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                nssfNumber = jtNSSFNo.getText();
                modify();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                nssfNumber = jtNSSFNo.getText();
                modify();
            }
        });
        
        jtNSSFNo.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                nssfNumber = jtNSSFNo.getText();            
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
        
        jtMaritalStatus.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Object[] options = {new JButton("Close")};
                DialogDisplayer.getDefault().notify(new DialogDescriptor(maritalTc, "Select Marital Status",true, options,null,DialogDescriptor.DEFAULT_ALIGN,null,null)); }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
        
        jdcDOB.setMaxSelectableDate(new Date());
        
        jdcDOB.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if(evt.getSource()==jdcDOB && "date".equals(evt.getPropertyName())){
                    dob = jdcDOB.getDate();
                    modify();
                }
            }
        });
        jtGender.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Object[] options = {new JButton("Close")};
                DialogDisplayer.getDefault().notify(new DialogDescriptor(genderTc, "Select Gender",true, options,null,DialogDescriptor.DEFAULT_ALIGN,null,null)); }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
        
        jtReligion.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Object[] options = {new JButton("Close")};
                DialogDisplayer.getDefault().notify(new DialogDescriptor(religionTc, "Select Religion",true, options,null,DialogDescriptor.DEFAULT_ALIGN,null,null)); }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
        
        jtNationalID.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                nationalID = jtNationalID.getText();
                modify();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                nationalID = jtNationalID.getText();
                modify();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                nationalID = jtNationalID.getText();
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

        jLabel1 = new javax.swing.JLabel();
        jtFirstName = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtLastName = new javax.swing.JTextField();
        jtGender = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtNationality = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtTribe = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtMaritalStatus = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtReligion = new javax.swing.JTextField();
        jtPassportNumber = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtNationalID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtNSSFNo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jdcDOB = new com.toedter.calendar.JDateChooser();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(PDREditorCompanyInfoPanel.class, "PDREditorCompanyInfoPanel.jLabel1.text")); // NOI18N

        jtFirstName.setText(org.openide.util.NbBundle.getMessage(PDREditorCompanyInfoPanel.class, "PDREditorCompanyInfoPanel.jtFirstName.text")); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(PDREditorCompanyInfoPanel.class, "PDREditorCompanyInfoPanel.jButton1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(PDREditorCompanyInfoPanel.class, "PDREditorCompanyInfoPanel.jLabel2.text")); // NOI18N

        jtLastName.setText(org.openide.util.NbBundle.getMessage(PDREditorCompanyInfoPanel.class, "PDREditorCompanyInfoPanel.jtLastName.text")); // NOI18N

        jtGender.setBackground(new java.awt.Color(0, 204, 0));
        jtGender.setText(org.openide.util.NbBundle.getMessage(PDREditorCompanyInfoPanel.class, "PDREditorCompanyInfoPanel.jtGender.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(PDREditorCompanyInfoPanel.class, "PDREditorCompanyInfoPanel.jLabel3.text")); // NOI18N

        jtNationality.setBackground(new java.awt.Color(0, 204, 0));
        jtNationality.setText(org.openide.util.NbBundle.getMessage(PDREditorCompanyInfoPanel.class, "PDREditorCompanyInfoPanel.jtNationality.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(PDREditorCompanyInfoPanel.class, "PDREditorCompanyInfoPanel.jLabel4.text")); // NOI18N

        jtTribe.setBackground(new java.awt.Color(0, 204, 0));
        jtTribe.setText(org.openide.util.NbBundle.getMessage(PDREditorCompanyInfoPanel.class, "PDREditorCompanyInfoPanel.jtTribe.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(PDREditorCompanyInfoPanel.class, "PDREditorCompanyInfoPanel.jLabel5.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(PDREditorCompanyInfoPanel.class, "PDREditorCompanyInfoPanel.jLabel6.text")); // NOI18N

        jtMaritalStatus.setBackground(new java.awt.Color(0, 204, 0));
        jtMaritalStatus.setText(org.openide.util.NbBundle.getMessage(PDREditorCompanyInfoPanel.class, "PDREditorCompanyInfoPanel.jtMaritalStatus.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel7, org.openide.util.NbBundle.getMessage(PDREditorCompanyInfoPanel.class, "PDREditorCompanyInfoPanel.jLabel7.text")); // NOI18N

        jtReligion.setBackground(new java.awt.Color(0, 204, 0));
        jtReligion.setText(org.openide.util.NbBundle.getMessage(PDREditorCompanyInfoPanel.class, "PDREditorCompanyInfoPanel.jtReligion.text")); // NOI18N

        jtPassportNumber.setText(org.openide.util.NbBundle.getMessage(PDREditorCompanyInfoPanel.class, "PDREditorCompanyInfoPanel.jtPassportNumber.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel8, org.openide.util.NbBundle.getMessage(PDREditorCompanyInfoPanel.class, "PDREditorCompanyInfoPanel.jLabel8.text")); // NOI18N

        jtNationalID.setText(org.openide.util.NbBundle.getMessage(PDREditorCompanyInfoPanel.class, "PDREditorCompanyInfoPanel.jtNationalID.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel9, org.openide.util.NbBundle.getMessage(PDREditorCompanyInfoPanel.class, "PDREditorCompanyInfoPanel.jLabel9.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel10, org.openide.util.NbBundle.getMessage(PDREditorCompanyInfoPanel.class, "PDREditorCompanyInfoPanel.jLabel10.text")); // NOI18N

        jtNSSFNo.setText(org.openide.util.NbBundle.getMessage(PDREditorCompanyInfoPanel.class, "PDREditorCompanyInfoPanel.jtNSSFNo.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel11, org.openide.util.NbBundle.getMessage(PDREditorCompanyInfoPanel.class, "PDREditorCompanyInfoPanel.jLabel11.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtPassportNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jtReligion, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jtMaritalStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jtTribe, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jtNationality, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jtGender, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jtLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jtFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jtNationalID, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jtNSSFNo, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jdcDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtNationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtTribe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jtMaritalStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jtReligion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jtPassportNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jtNationalID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jtNSSFNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jdcDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 88, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(37, 37, 37))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser jdcDOB;
    private javax.swing.JTextField jtFirstName;
    private javax.swing.JTextField jtGender;
    private javax.swing.JTextField jtLastName;
    private javax.swing.JTextField jtMaritalStatus;
    private javax.swing.JTextField jtNSSFNo;
    private javax.swing.JTextField jtNationalID;
    private javax.swing.JTextField jtNationality;
    private javax.swing.JTextField jtPassportNumber;
    private javax.swing.JTextField jtReligion;
    private javax.swing.JTextField jtTribe;
    // End of variables declaration//GEN-END:variables

    @Override
    public void resultChanged(LookupEvent le) {
        Lookup.Result result = (Lookup.Result)le.getSource();
        for (Object e: result.allInstances()){
            if(e instanceof Employees){
                
                resetEditor();
                edit = true;
                emp = (Employees)e;
                try{
                jtFirstName.setText( ((Employees) e).getOtherNames());
                }catch(NullPointerException ex){
                    // When some info is missing
                }
                try{
                jtLastName.setText(((Employees) e).getSurName());
                }catch(NullPointerException ex){
                    // When some info is missing
                }
                try{
                Gender g = new Gender(((Employees) e).getGender());
                
                jtGender.setText(g.toString());
                }catch(NullPointerException ex){
                    // When some info is missing
                }
                try{
                jtNationality.setText(((Employees) e).getNationalityID().getNationality());
                }catch(NullPointerException ex){
                    // When some info is missing
                }
                try{
                    edit = false;    
                    jdcDOB.setDate(((Employees) e).getDateOfBirth());
                    edit = true;
                
                }catch(NullPointerException ex){
                    // When some info is missing
                }
                try{
                Marital m = new Marital(((Employees) e).getMaritalStatus());
                
                jtMaritalStatus.setText(m.toString());
                }catch(NullPointerException ex){
                    // When some info is missing
                }
                try{
                jtTribe.setText(((Employees) e).getTribeID().getTribe());
                }catch(NullPointerException ex){
                    // When some info is missing
                }
                try{
                jtReligion.setText(((Employees) e).getReligionID().getReligion());
                }catch(NullPointerException ex){
                    // When some info is missing
                }
                try{
                jtPassportNumber.setText(((Employees) e).getPassportNo());
                }catch(NullPointerException ex){
                    // When some info is missing
                }
                try{
                jtNationalID.setText(((Employees) e).getNHIFNo());
                }catch(NullPointerException ex){
                    // When some info is missing
                }
                try{
                jtNSSFNo.setText(((Employees) e).getNSSFNo());
                }catch(NullPointerException ex){
                    // When some info is missing
                }
                
            }
            
            if(e instanceof Tribes){
                tribeID = (Tribes)e;
                jtTribe.setText(((Tribes) e).getTribe());
                modify();
            }
            
            if(e instanceof Nationalities){
                nationalityID = (Nationalities)e;
                jtNationality.setText(((Nationalities) e).getNationality());
                modify();
            }
            
            if(e instanceof Gender){
                genderID = ((Gender) e).getCode();
                jtGender.setText(((Gender) e).toString());
                modify();
            }
            
            if(e instanceof Religions){
                religionID = (Religions) e;
                jtReligion.setText(((Religions) e).getReligion());
                modify();
            }
            if(e instanceof Marital){
                maritalStatusID = ((Marital) e).getCode();
                jtMaritalStatus.setText(((Marital)e).toString());
                modify();
            }
        }
    }
    
    void modify(){
        if(edit){
            if(getLookup().lookup(MySavable.class)==null){
                Utility.editorIC.add(new MySavable());
            }
        } else {
            
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
            return "Employee";
        }

        @Override
        protected void handleSave() throws IOException {
            
            //If it is an update
            if(emp != null ){
            Utility.editorIC.remove(this);
            unregister();
            entityManager.getTransaction().begin();
            Employees e = entityManager.find(Employees.class, emp.getEmployeeID());
            if(null != tribeID){
            e.setTribeID(tribeID);
            }
            if(null != nationalityID)
            {
            e.setNationalityID(nationalityID);
            }
            
            if(fname!=null){
                e.setOtherNames(fname);
            }
            
            if(lname != null){
                e.setSurName(lname);
            }
            
            if(dob != null){
            e.setDateOfBirth(dob);
            }
            if(genderID != null){
            e.setGender(genderID);
            }
            if(maritalStatusID != null){
            e.setMaritalStatus(maritalStatusID);
            }
            
            if(religionID != null){
            e.setReligionID(religionID);
            }
            
            if(passportNumber != null){
            e.setPassportNo(passportNumber);
            }
            
            if(nationalID != null){
            e.setNHIFNo(nationalID);
            }
            
            if(nssfNumber != null){
            e.setNSSFNo(nssfNumber);
            }
            
            
            entityManager.getTransaction().commit();
            }else{
                //It is a new entry 
                
                Utility.editorIC.remove(this);
                unregister();
                entityManager.getTransaction().begin();
            
                
            String insertSQL = "INSERT INTO [dbo].[Employees]\n" +
"           ([SurName]\n" +
"           ,[OtherNames]\n" +
"           ,[DateOfBirth]\n" +
"           ,[Gender]\n" +
"           ,[MaritalStatus]\n" +
"           ,[NationalityID]\n" +
"           ,[TribeID]\n" +
"           ,[ReligionID]\n" +
"           ,[PassportNo]\n" +
"           ,[NHIFNo]\n" +
"           ,[NSSFNo]\n" +
"           ,[Photo]\n" +
"           ,[isDeleted]\n" +                    
"           ,[isDisengaged])\n" +                    
"     VALUES\n" +
"           (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            Query query = entityManager.createNativeQuery(insertSQL);
            query.setParameter(1, lname);
            query.setParameter(2, fname);
            query.setParameter(3, dob);
            query.setParameter(4, genderID);
            query.setParameter(5, maritalStatusID);
            query.setParameter(6, nationalityID.getNationalityID());
            query.setParameter(7, tribeID.getTribeID());
            query.setParameter(8, religionID.getReligionID());
            query.setParameter(9, passportNumber);
            query.setParameter(11, nationalID);
            //query.setParameter(12, genderID);
            query.setParameter(13, false);
            query.setParameter(14, false);
            query.executeUpdate();
            entityManager.getTransaction().commit(); 
            
            
                
            }
            
        }
        
        PDREditorCompanyInfoPanel pnel(){
            return PDREditorCompanyInfoPanel.this;
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
        jtFirstName.setText("");
        jtGender.setText("");
        jtLastName.setText("");
        jtMaritalStatus.setText("");
        jtNSSFNo.setText("");
        jtNationalID.setText("");
        jtNationality.setText("");
        jtPassportNumber.setText("");
        jtReligion.setText("");
        jtTribe.setText("");
        fname = null;
        lname = null;
        genderID = null;
        tribeID = null;
        maritalStatusID =null;
        nationalityID =null;
        religionID = null;
        passportNumber = null;
        nationalID = null;
        nssfNumber = null;
        dob = null;
    }
}
