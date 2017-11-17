/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systems.tech247.dbaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.openide.awt.StatusDisplayer;
import systems.tech247.hr.Awards;
import systems.tech247.hr.Banks;
import systems.tech247.hr.CompanyAssetIssue;
import systems.tech247.hr.CompanyAssets;
import systems.tech247.hr.Contacts;
import systems.tech247.hr.Countries;
import systems.tech247.hr.Ctypes;
import systems.tech247.hr.Currencies;
import systems.tech247.hr.Edu;
import systems.tech247.hr.EmployeeBankAccounts;

import systems.tech247.hr.Employees;
import systems.tech247.hr.Employment;
import systems.tech247.hr.Family;
import systems.tech247.hr.JDCategories;
import systems.tech247.hr.JobPositionJDs;
import systems.tech247.hr.JobPositions;
import systems.tech247.hr.Kin;
import systems.tech247.hr.Locations;
import systems.tech247.hr.Nationalities;
import systems.tech247.hr.OrganizationUnitTypes;
import systems.tech247.hr.OrganizationUnits;
import systems.tech247.hr.Prof;
import systems.tech247.hr.Ref;
import systems.tech247.hr.Religions;
import systems.tech247.hr.Tribes;
import systems.tech247.hr.Visa;

/**
 *
 * @author Admin
 */
public class DataAccess {
    
    
    
    
    public static EntityManager getEntityManager(){
        return Persistence.createEntityManagerFactory("HRLibPU").createEntityManager();
    }
    
    
    public List<Employees> searchEmployees(String search){
        TypedQuery<Employees> query = getEntityManager().createQuery(search,Employees.class);
        return query.getResultList();
        
    }
    
    
    
    public List<Contacts> searchContacts(Employees emp){
        String sql = "SELECT * FROM contacts r WHERE r.employee_id = "+emp.getEmployeeID()+ "";
        Query query = getEntityManager().createNativeQuery(sql,Contacts.class);
        return query.getResultList();
        
    }
    
    public List<CompanyAssetIssue> searchAssetsIssued(Employees emp){
        String sql = "SELECT * FROM CompanyAssetIssue r WHERE r.employee_id = "+emp.getEmployeeID()+ "";
        Query query = getEntityManager().createNativeQuery(sql,CompanyAssetIssue.class);
        return query.getResultList();
        
    }
    
    public List<Visa> searchVisa(Employees emp){
        String sql = "SELECT * FROM Visa r WHERE r.employee_id = "+emp.getEmployeeID()+ "";
        Query query = getEntityManager().createNativeQuery(sql,Visa.class);
        return query.getResultList();
        
    }
    
    public List<EmployeeBankAccounts> searchBankAccounts(Employees emp){
        String sql = "SELECT * FROM EmployeeBankAccounts r WHERE r.employeeid = "+emp.getEmployeeID()+ "";
        Query query = getEntityManager().createNativeQuery(sql,EmployeeBankAccounts.class);
        return query.getResultList();
        
    }
    
    public List<Awards> searchAwards(Employees emp){
        String sql = "SELECT * FROM Awards r WHERE r.employee_id = "+emp.getEmployeeID()+ "";
        Query query = getEntityManager().createNativeQuery(sql,Awards.class);
        return query.getResultList();
        
    }
    
    public List<Employment> searchEmployment(Employees emp){
        String sql = "SELECT * FROM Employment r WHERE r.employee_id = "+emp.getEmployeeID()+ "";
        Query query = getEntityManager().createNativeQuery(sql,Employment.class);
        return query.getResultList();
        
    }
    
    public List<Family> searchFamily(Employees emp){
        String sql = "SELECT * FROM family r WHERE r.employee_id = "+emp.getEmployeeID()+ "";
        Query query = getEntityManager().createNativeQuery(sql,Family.class);
        return query.getResultList();
        
    }
    
    public List<Kin> searchKin(Employees emp){
        String sql = "SELECT * FROM Kin r WHERE r.employee_id = "+emp.getEmployeeID()+ "";
        Query query = getEntityManager().createNativeQuery(sql,Kin.class);
        return query.getResultList();
        
    }
    
    public List<Ref> searchReferees(Employees emp){
        String sql = "SELECT * FROM ref r WHERE r.employee_id = "+emp.getEmployeeID()+ "";
        Query query = getEntityManager().createNativeQuery(sql,Ref.class);
        return query.getResultList();
        
    }
    
    public List<Edu> searchEducation(Employees emp){
        String sql = "SELECT * FROM Edu r WHERE r.employee_id = "+emp.getEmployeeID()+ "";
        Query query = getEntityManager().createNativeQuery(sql,Edu.class);
        return query.getResultList();
        
    }
    
    public List<Prof> searchProf(Employees emp){
        String sql = "SELECT * FROM Prof r WHERE r.employee_id = "+emp.getEmployeeID()+ "";
        Query query = getEntityManager().createNativeQuery(sql,Prof.class);
        return query.getResultList();
        
    }
    

    
    
    
    
    public List<Currencies> searchCurrencies(String search){
        TypedQuery<Currencies> query = getEntityManager().createQuery(search,Currencies.class);
        return query.getResultList();
        
    }
    
    public List<Countries> searchCountries(String search){
        
        TypedQuery<Countries> query = getEntityManager().createQuery(search,Countries.class);
        return query.getResultList();
        
    }
    
    public List<CompanyAssets> searchCompanyAssets(String search){
        Query query = getEntityManager().createNativeQuery(search,CompanyAssets.class);
        return query.getResultList();
    }
    
    public List<Tribes> searchTribes(String search){
        TypedQuery<Tribes> query = getEntityManager().createQuery(search,Tribes.class);
        return query.getResultList();
        
    }
    
    public List<JobPositions> searchJobPositions(String search){
        TypedQuery<JobPositions> query = getEntityManager().createQuery(search,JobPositions.class);
        return query.getResultList();
        
    }
    
    public List<JDCategories> searchJDCategories(String search){
        
        TypedQuery<JDCategories> query = getEntityManager().createQuery(search,JDCategories.class);
        return query.getResultList();
        
    }
    
    public List<JobPositionJDs> searchJDsForJobAndCategory(JobPositions position,int categoryID){
        String sql = "SELECT * FROM JobPositionJDs r WHERE r.PositionID = "+position.getPositionID()+ " AND r.JDCategoryID =  "+categoryID+"";
        Query query = getEntityManager().createNativeQuery(sql,JobPositionJDs.class);
        return query.getResultList();
        
    }
    
    public List<Integer> searchJDCategoriesForJob(JobPositions position){
        String sql = "SELECT DISTINCT JDCategoryID FROM JobPositionJDs r WHERE r.PositionID = "+position.getPositionID()+ "";
        Query query = getEntityManager().createNativeQuery(sql);
        //StatusDisplayer.getDefault().setStatusText("SQL: "+ sql+ " Categories: "+ query.getResultList().size());
        return query.getResultList();
        
    }
    
    public List<JobPositionJDs> searchJDs(String search){
        
        TypedQuery<JobPositionJDs> query = getEntityManager().createQuery(search,JobPositionJDs.class);
        return query.getResultList();
        
    }
    
    public List<Banks> searchBanks(String search){
        TypedQuery<Banks> query = getEntityManager().createQuery(search,Banks.class);
        return query.getResultList();
        
    }
    
    public List<OrganizationUnits> searchDepartments(String search){
        TypedQuery<OrganizationUnits> query = getEntityManager().createQuery(search,OrganizationUnits.class);
        
        return query.getResultList();
        
    }
    
    public List<JobPositions> searchPositions(String search){
        TypedQuery<JobPositions> query = getEntityManager().createQuery(search,JobPositions.class);
        return query.getResultList();
        
    }
    
    
    
    
    public List<Religions> searchReligions(String search){
        TypedQuery<Religions> query = getEntityManager().createQuery(search,Religions.class);
        return query.getResultList();
        
    }
    
    public List<Ctypes> searchCtypes(String search){
        TypedQuery<Ctypes> query = getEntityManager().createQuery(search,Ctypes.class);
        return query.getResultList();
        
    }
    
    public List<OrganizationUnitTypes> searchOuTypes(String search){
        TypedQuery<OrganizationUnitTypes> query = getEntityManager().createQuery(search,OrganizationUnitTypes.class);
        return query.getResultList();
        
    }
    
    public List<Locations> searchLocations(String search){
        TypedQuery<Locations> query = getEntityManager().createQuery(search,Locations.class);
        return query.getResultList();
        
    }
    
    public List<Nationalities> searchNations(String search){
        TypedQuery<Nationalities> query = getEntityManager().createQuery(search,Nationalities.class);
        return query.getResultList();
        
    }
}
