/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systems.tech247.pdreditors;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

@ActionID(
        category = "PDR",
        id = "systems.tech247.pdreditors.NewEmployee"
)
@ActionRegistration(
        iconBase = "systems/tech247/pdreditors/personadd.png",
        displayName = "#CTL_NewEmployee"
)
@ActionReferences({
    @ActionReference(path = "Menu/File", position = 1300)
    ,
  @ActionReference(path = "Toolbars/PDR", position = 720)
})
@Messages("CTL_NewEmployee=Add New Employee")
public final class ActionNewEmployee implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        
        TopComponent empEditor =WindowManager.getDefault().findTopComponent("EmployeeEditorTopComponent");
        empEditor.open();
        
        
        NotifyDescriptor nd = new NotifyDescriptor(new EditorNewEmployeePanel(1), "New Employee", NotifyDescriptor.OK_CANCEL_OPTION,
                NotifyDescriptor.PLAIN_MESSAGE, new Object[]{}, null);
        //nd.setNoDefaultClose(true);  
        DialogDisplayer.getDefault().notifyLater(nd);
    }
}
