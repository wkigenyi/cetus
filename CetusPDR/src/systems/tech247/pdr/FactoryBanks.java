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
import systems.tech247.hr.Banks;
import systems.tech247.pdreditors.PDRBankBranchEditor;
import systems.tech247.pdreditors.PDRBankEditor;
import systems.tech247.util.CapCreatable;
import systems.tech247.util.CapDeletable;
import systems.tech247.util.CapEditable;

import systems.tech247.util.ReloadableQueryCapability;

/**
 *
 * @author Wilfred
 */
public class FactoryBanks extends ChildFactory<Banks>{

    QueryBanks query;
    Boolean edit;
    
    public FactoryBanks(QueryBanks query, Boolean edit){
        this.query = query;
        this.edit = edit; 
                
    }
    
    @Override
    protected boolean createKeys(List<Banks> list) {
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
    protected Node createNodeForKey(Banks key){
        Node node = new BankNode(key);
       
        
        return node;
    }
    
    private class BankNode extends AbstractNode{
        
        private final InstanceContent instanceContent;
        
        public BankNode(Banks bank){
            this(new InstanceContent(),bank);
        }
        
        private BankNode (InstanceContent ic, final Banks bank){
            super(Children.create(new FactoryBankBranches(bank,edit), true), new AbstractLookup(ic));
            ic.add(bank);
            if(edit){
                ic.add(new CapEditable() {
                    @Override
                    public void edit() {
                        NotifyDescriptor nd = new NotifyDescriptor(new PDRBankEditor(bank), "Edit Bank", NotifyDescriptor.OK_CANCEL_OPTION,
                NotifyDescriptor.PLAIN_MESSAGE, new Object[]{}, null);
        //nd.setNoDefaultClose(true);  
        DialogDisplayer.getDefault().notifyLater(nd);
                    }
                });
                
                ic.add(new CapCreatable() {
                    @Override
                    public void create() {
                        NotifyDescriptor nd = new NotifyDescriptor(new PDRBankBranchEditor(bank), "Add New Branch", NotifyDescriptor.OK_CANCEL_OPTION,
                NotifyDescriptor.PLAIN_MESSAGE, new Object[]{}, null);
        //nd.setNoDefaultClose(true);  
        DialogDisplayer.getDefault().notifyLater(nd);
                    }
                });
                
                ic.add(new CapDeletable() {
                    @Override
                    public void delete() {
                        StatusDisplayer.getDefault().setStatusText("Delete the Bank");
                    }
                });
            }
            
            instanceContent = ic;
            
            
            
            setIconBaseWithExtension("systems/tech247/util/icons/settings.png");
            setDisplayName(bank.getBankName());
        }
    
}
    
}
