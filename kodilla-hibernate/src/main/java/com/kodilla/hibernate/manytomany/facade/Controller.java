package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Controller {
    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    public Controller(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public List retrieveCompaniesByName(String fragment){
        return companyDao.retrieveCompaniesWithName(fragment);
    }

    public List retrieveEmployeesByName(String fragment){
        return employeeDao.retrieveEmployeesWithName(fragment);
    }

    public void saveCompany(Company company){
        companyDao.save(company);
    }

    public void saveEmployee(Employee employee){
        employeeDao.save(employee);
    }

    public void deleteCompany(Company company){
            companyDao.delete(company);
    }

    public void deleteEmployee(Employee employee){
        employeeDao.delete(employee);
    }

    public void deleteAll(){
        employeeDao.deleteAll();
        companyDao.deleteAll();
    }
}
