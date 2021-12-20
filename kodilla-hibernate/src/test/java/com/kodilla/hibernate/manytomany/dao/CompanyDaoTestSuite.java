package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    void testQueries(){
        //Given
        Employee employee1 = new Employee("John", "Smith");
        Employee employee2 = new Employee("Anna", "Stark");
        Employee employee3 = new Employee("Peter", "Parker");

        Company company1 = new Company("Aroplex");
        Company company2 = new Company("AroBust");
        Company company3 = new Company("Fegis");

        company1.getEmployees().add(employee1);
        company2.getEmployees().add(employee2);
        company3.getEmployees().add(employee3);

        employee1.getCompanies().add(company1);
        employee2.getCompanies().add(company2);
        employee3.getCompanies().add(company3);

        //When
        companyDao.save(company1);
        companyDao.save(company2);
        companyDao.save(company3);

        int id1 = company1.getId();
        int id2 = company2.getId();
        int id3 = company3.getId();

        employeeDao.save(employee1);
        employeeDao.save(employee2);
        employeeDao.save(employee3);

        List<Employee> employeesByLastName = employeeDao.retrieveEmployeeWithLastName("Smith");

        List<Company> companiesWithThreeLetters
                = companyDao.retrieveCompaniesByFirstThreeLetters("Aro");

        //Then
        try {
            assertEquals(2, companiesWithThreeLetters.size());
            assertEquals(1, employeesByLastName.size());

        } finally{
            //cleanUp
            companyDao.deleteById(id1);
            companyDao.deleteById(id2);
            companyDao.deleteById(id3);
        }
    }
}