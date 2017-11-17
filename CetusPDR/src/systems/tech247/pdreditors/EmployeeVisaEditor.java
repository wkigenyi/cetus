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
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JButton;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.awt.StatusDisplayer;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import systems.tech247.dbaccess.DataAccess;
import systems.tech247.hr.BankBranches;
import systems.tech247.hr.Currencies;
import systems.tech247.hr.Employees;
import systems.tech247.hr.Visa;
import systems.tech247.pdr.Utility;


/**
 *
 * @author Admin
 */
public class EmployeeVisaEditor extends javax.swing.JPanel implements LookupListener{

    
    
    DataAccess da = new DataAccess();
    Visa visa;
    Employees employeeID;
    
    
    //Updatables
    String nationality = null;
    String permit = null;
    String vclass = null;
    int years = 0;
    Currencies currency = null;
    String receiptNo = null;
    Date fro = null;
    Date to = null;
    String title = null;
    EntityManager entityManager = da.getEntityManager();
    TopComponent empTc = WindowManager.getDefault().findTopComponent("EmployeesTopComponent");
    Lookup.Result<Employees> empRslt = empTc.getLookup().lookupResult(Employees.class);
    TopComponent currencyTc = WindowManager.getDefault().findTopComponent("CurrenciesTopComponent");
    Lookup.Result<Currencies> currencyRslt = currencyTc.getLookup().lookupResult(Currencies.class);
   
    /**
     * Creates new form PersonalInfoPanel
     */
    public EmployeeVisaEditor(Visa visa){
        this(visa.getEmployeeId(),visa);
    }
    
    public EmployeeVisaEditor(Employees emp){
        this(emp,null);
    }
    
    
 public EmployeeVisaEditor(Employees empID,Visa visa) {
        initComponents();
        //Start transaction
        this.visa = visa;
        
        if(visa != null){
            jtNationality.setText(visa.getNationality());
            jtPermit.setText(visa.getPermit());
            jtClass.setText(visa.getClass1());
            
            jtYears.setText(visa.getYears()+"");
            jtCurrency.setText(visa.getCurrencyId().getCurrencyCode());
            jdcFrom.setDate(visa.getCFrom());
            jdcTo.setDate(visa.getCTo());
            jtReceiptNo.setText(visa.getRcptNo());
            jtTitle.setText(visa.getTitle());
        }
        
        
        currencyRslt.addLookupListener(this);
        resultChanged(new LookupEvent(empRslt));
        
        employeeID = empID;
        jtCurrency.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                Object[] options = {new JButton("Close")};
                DialogDisplayer.getDefault().notify(new DialogDescriptor(currencyTc, "Currency",true, options,null,DialogDescriptor.DEFAULT_ALIGN,null,null)); }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
        
        jtPermit.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                permit = jtPermit.getText();
                modify();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                permit = jtPermit.getText();
                modify();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                permit = jtPermit.getText();
                modify();
            }
        });
        
        jtNationality.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                nationality = jtNationality.getText();
                modify();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                nationality = jtNationality.getText();
                modify();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                nationality = jtNationality.getText();
                modify();
            }
        });
        
        
        
        jtYears.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                try{
                years = Integer.getInteger(jtYears.getText());
                modify();
                }catch(Exception ex){
                    
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                try{
                years = Integer.getInteger(jtYears.getText());
                modify();
                }catch(Exception ex){
                    
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                try{
                years = Integer.getInteger(jtYears.getText());
                modify();
                }catch(Exception ex){
                    
                }
            }
        });
        
        jtClass.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                vclass = jtClass.getText();
                modify();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                vclass = jtClass.getText();
                modify();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                vclass = jtClass.getText();
                modify();
            }
        });
        
         jtReceiptNo.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                receiptNo = jtReceiptNo.getText();
                modify();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                receiptNo = jtReceiptNo.getText();
                modify();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                receiptNo = jtReceiptNo.getText();
                modify();
            }
        });
         
                  jtTitle.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                title = jtTitle.getText();
                modify();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                title = jtTitle.getText();
                modify();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                title = jtTitle.getText();
                modify();
            }
        });
         
         
         
         
         
         
         jdcFrom.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if(evt.getPropertyName()=="date" && evt.getSource()==jdcFrom){
                    fro = jdcFrom.getDate();
                }
            }
        });
         
         jdcTo.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if(evt.getPropertyName()=="date" && evt.getSource()==jdcTo){
                    to = jdcTo.getDate();
                }
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
        jtPermit = new javax.swing.JTextField();
        jtNationality = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtClass = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtYears = new javax.swing.JTextField();
        jdcFrom = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jdcTo = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jtTitle = new javax.swing.JTextField();
        jtCurrency = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtReceiptNo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jbSave = new javax.swing.JButton();

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(EmployeeVisaEditor.class, "EmployeeVisaEditor.jLabel3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(EmployeeVisaEditor.class, "EmployeeVisaEditor.jLabel1.text")); // NOI18N

        jtPermit.setText(org.openide.util.NbBundle.getMessage(EmployeeVisaEditor.class, "EmployeeVisaEditor.jtPermit.text")); // NOI18N

        jtNationality.setText(org.openide.util.NbBundle.getMessage(EmployeeVisaEditor.class, "EmployeeVisaEditor.jtNationality.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(EmployeeVisaEditor.class, "EmployeeVisaEditor.jLabel4.text")); // NOI18N

        jtClass.setText(org.openide.util.NbBundle.getMessage(EmployeeVisaEditor.class, "EmployeeVisaEditor.jtClass.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(EmployeeVisaEditor.class, "EmployeeVisaEditor.jLabel5.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(EmployeeVisaEditor.class, "EmployeeVisaEditor.jLabel6.text")); // NOI18N

        jtYears.setText(org.openide.util.NbBundle.getMessage(EmployeeVisaEditor.class, "EmployeeVisaEditor.jtYears.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel7, org.openide.util.NbBundle.getMessage(EmployeeVisaEditor.class, "EmployeeVisaEditor.jLabel7.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel8, org.openide.util.NbBundle.getMessage(EmployeeVisaEditor.class, "EmployeeVisaEditor.jLabel8.text")); // NOI18N

        jtTitle.setText(org.openide.util.NbBundle.getMessage(EmployeeVisaEditor.class, "EmployeeVisaEditor.jtTitle.text")); // NOI18N

        jtCurrency.setText(org.openide.util.NbBundle.getMessage(EmployeeVisaEditor.class, "EmployeeVisaEditor.jtCurrency.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel9, org.openide.util.NbBundle.getMessage(EmployeeVisaEditor.class, "EmployeeVisaEditor.jLabel9.text")); // NOI18N

        jtReceiptNo.setText(org.openide.util.NbBundle.getMessage(EmployeeVisaEditor.class, "EmployeeVisaEditor.jtReceiptNo.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel10, org.openide.util.NbBundle.getMessage(EmployeeVisaEditor.class, "EmployeeVisaEditor.jLabel10.text")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtNationality, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(jtPermit)
                    .addComponent(jtClass)
                    .addComponent(jtYears)
                    .addComponent(jdcFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdcTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtTitle)
                    .addComponent(jtCurrency)
                    .addComponent(jtReceiptNo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtNationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtPermit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtYears, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jtReceiptNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jdcFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jdcTo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.openide.awt.Mnemonics.setLocalizedText(jbSave, org.openide.util.NbBundle.getMessage(EmployeeVisaEditor.class, "EmployeeVisaEditor.jbSave.text")); // NOI18N
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbSave, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSave)
                .addGap(8, 8, 8))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSaveActionPerformed
        entityManager.getTransaction().begin();    
        
        if(visa == null){ //Add New Account
            String insertSQL = "INSERT INTO [dbo].[Visa]\n" +
"           ([Employee_ID]\n" +
"           ,[Nationality]\n" +
"           ,[Permit]\n" +
"           ,[Years]\n" +
"           ,[Title]\n" +
"           ,[CurrencyID]\n" +
"           ,[CFrom]\n" +
"           ,[CTo]\n" +
"           ,[Class]\n" +   
"           ,[RcptNo])\n" +                    

"     VALUES\n" +
"           (?,?,?,?,?,?,?,?,?,?)";
            Query query = entityManager.createNativeQuery(insertSQL);
            query.setParameter(1, employeeID.getEmployeeID());
            query.setParameter(2, nationality);
            query.setParameter(3, permit);
            query.setParameter(4, years);
            query.setParameter(5, title);
            query.setParameter(6, currency.getCurrencyID());
            query.setParameter(7, fro);
            query.setParameter(8, to);
            query.setParameter(9, vclass);
            query.setParameter(10, receiptNo);
            
            query.executeUpdate();
            entityManager.getTransaction().commit(); 
            
            resetEditor();
            StatusDisplayer.getDefault().setStatusText("Visa Added");
            Utility.loadVisas(employeeID);
        }else{
            
            Visa eva = entityManager.find(Visa.class, visa.getId());
            
            if(null != permit){
                eva.setPermit(permit);
            }
            
            if(null != nationality){
                eva.setNationality(nationality);
            }
            
            if(null != receiptNo){
                eva.setRcptNo(receiptNo);
            }
            
            if(null != to){
                eva.setCTo(to);
            }
            
            if(null != fro){
                eva.setCFrom(fro);
            }
            
            if(null != vclass){
                eva.setClass1(vclass);
            }
            
            if(null != title){
                eva.setTitle(title);
            }
            
            if(null != currency){
                eva.setCurrencyId(currency);
            }
            
            if(0 != years){
                eva.setYears(years);
            }
           
            
            
            //eba.setIsMainAccount(isMain);
            //eba.setDeleted(isDeleted);
            
            entityManager.getTransaction().commit();
            StatusDisplayer.getDefault().setStatusText("Visa Saved");
            Utility.loadVisas(employeeID);
            resetEditor();
        }
        

    }//GEN-LAST:event_jbSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbSave;
    private com.toedter.calendar.JDateChooser jdcFrom;
    private com.toedter.calendar.JDateChooser jdcTo;
    private javax.swing.JTextField jtClass;
    private javax.swing.JTextField jtCurrency;
    private javax.swing.JTextField jtNationality;
    private javax.swing.JTextField jtPermit;
    private javax.swing.JTextField jtReceiptNo;
    private javax.swing.JTextField jtTitle;
    private javax.swing.JTextField jtYears;
    // End of variables declaration//GEN-END:variables

    @Override
    public void resultChanged(LookupEvent le) {
        Lookup.Result result = (Lookup.Result)le.getSource();
        for (Object e: result.allInstances()){
            
                
                
               if(e instanceof Currencies){
                currency = ((Currencies) e);
                jtCurrency.setText(currency.getCurrencyCode());
                modify();
            } 
                
                
                
                
                
                
            }
            
            
            
            
            
            
            
            
            
        }
    
    
    void modify(){
        
                jbSave.setEnabled(true);
            
        
    }

    
    public Lookup getLookup() {
        TopComponent tc = WindowManager.getDefault().findTopComponent("EmployeeEditorTopComponent");
        return tc.getLookup();
    }
    
    
    
    void resetEditor(){
        jtNationality.setText("");
        jtPermit.setText("");
       
        jtClass.setText("");
        jtYears.setText("");
        jdcFrom.setDate(null);
        jdcTo.setDate(null);
        jtTitle.setText("");
        jtCurrency.setText("");
        nationality = null;
        receiptNo = null;
        years = 0;
        currency = null;
        fro = null;
        to = null;
    }
    
    


}
