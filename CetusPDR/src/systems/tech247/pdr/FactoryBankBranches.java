/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systems.tech247.pdr;

import java.util.List;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.awt.StatusDisplayer;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;
import systems.tech247.hr.BankBranches;
import systems.tech247.hr.Banks;
import systems.tech247.pdreditors.PDRBankBranchEditor;
import systems.tech247.util.CapDeletable;
import systems.tech247.util.CapEditable;

import systems.tech247.util.ReloadableQueryCapability;

/**
 *
 * @author Wilfred
 */
public class FactoryBankBranches extends ChildFactory<BankBranches>{

    QueryBankBranches query;
    Boolean edit;
    
    public FactoryBankBranches(Banks bank, Boolean edit){
        this.query = new QueryBankBranches(bank);
        this.edit = edit;
    }
    
    @Override
    protected boolean createKeys(List<BankBranches> list) {
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
    protected Node createNodeForKey(BankBranches key){
        Node node = new BranchNode(key);
       
        
        return node;
    }
    
    private class BranchNode extends AbstractNode{
        
        private final InstanceContent instanceContent;
        
        public BranchNode(BankBranches emp){
            this(new InstanceContent(),emp);
        }
        
        private BranchNode (InstanceContent ic, final BankBranches emp){
            super(Children.LEAF, new AbstractLookup(ic));
            instanceContent = ic;
            instanceContent.add(emp);
            
            if(edit){
            
            instanceContent.add(new CapEditable() {
                @Override
                public void edit() {
                    NotifyDescriptor nd = new NotifyDescriptor(new PDRBankBranchEditor(emp), "Edit Branch", NotifyDescriptor.OK_CANCEL_OPTION,
                NotifyDescriptor.PLAIN_MESSAGE, new Object[]{}, null);
        //nd.setNoDefaultClose(true);  
        DialogDisplayer.getDefault().notifyLater(nd);
                }
            });
            
            instanceContent.add(new CapDeletable() {
                @Override
                public void delete() {
                    StatusDisplayer.getDefault().setStatusText("Deleting Branch"); //To change body of generated methods, choose Tools | Templates.
                }
            });
            }
            setIconBaseWithExtension("systems/tech247/util/icons/settings.png");
            setDisplayName(emp.getBranchName());
        }
    
}
    
}
