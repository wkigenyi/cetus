/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systems.tech247.pdr;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.progress.ProgressHandleFactory;
import org.openide.util.Lookup;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;
import systems.tech247.dbaccess.DataAccess;
import systems.tech247.hr.EmployeeBankAccounts;
import systems.tech247.hr.Employees;
import systems.tech247.util.ReloadableQueryCapability;

/**
 *
 * @author Wilfred
 */
public class QueryBankAccounts implements Lookup.Provider {
    
    InstanceContent ic;
    Lookup lookup;
    Employees emp;
    private List<EmployeeBankAccounts> list;
    
    public QueryBankAccounts(final Employees emp){
        this.emp = emp;
        list = new ArrayList<>();
        // create an InstanceContent to hold capabilities
        ic = new InstanceContent();
        // create an abstract look to expose the contents of the instance content
        lookup = new AbstractLookup(ic);
        //Add a reloadable capabiliry to the instance content
        ic.add(new ReloadableQueryCapability() {
            @Override
            public void reload() throws Exception {
                
                getList().removeAll(list);
                ProgressHandle ph = ProgressHandleFactory.createHandle("Loading Accounts..");
                ph.start();
                DataAccess da = new DataAccess();
                Collection<EmployeeBankAccounts> list = da.searchBankAccounts(emp);
                for (EmployeeBankAccounts e: list){
                    
                        getList().add(e);
                    
                }
                ph.finish();
            }
        });
    }

    @Override
    public Lookup getLookup() {
        return lookup;
    }

    /**
     * @return the sqlString
     */
    

    /**
     * @param sqlString the sqlString to set
     */
    

    /**
     * @return the list
     */
    public List<EmployeeBankAccounts> getList() {
        return list;
    }
    
}
