package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

@SpringBootTest
public class FacadeTestSuit {

    @Autowired
    private Controller controller;

    @Test
    public void testRetrieveCompany() {
        //Given
        Employee employee1 = new Employee("Robert", "Nowak");
        Employee employee2 = new Employee("Kasia", "Nowakowska");
        Employee employee3 = new Employee("Mariusz", "Kowalski");

        Company company1 = new Company("Software Machines");
        Company company2 = new Company("Computer Machines");
        Company company3 = new Company("Microsoft");

        employee1.getCompanies().add(company1);
        employee1.getCompanies().add(company2);
        employee2.getCompanies().add(company2);
        employee3.getCompanies().add(company3);

        company1.getEmployees().add(employee1);
        company2.getEmployees().add(employee1);
        company2.getEmployees().add(employee2);
        company3.getEmployees().add(employee3);

        controller.saveEmployee(employee1);
        controller.saveEmployee(employee2);
        controller.saveEmployee(employee3);

        controller.saveCompany(company1);
        controller.saveCompany(company2);
        controller.saveCompany(company3);

        //When
        List<Company> companiesByName = controller.retrieveCompaniesByName("%machi%");

        //Then
        assertEquals(2, companiesByName.size());

        //CleanUp
        controller.deleteEmployee(employee1);
        controller.deleteEmployee(employee2);
        controller.deleteEmployee(employee3);

        controller.deleteCompany(company1);
        controller.deleteCompany(company2);
        controller.deleteCompany(company3);
    }

    @Test
    public void testRetrieveEmployees() {
        //Given
        Employee employee1 = new Employee("Robert", "Nowak");
        Employee employee2 = new Employee("Kasia", "Nowakowska");
        Employee employee3 = new Employee("Mariusz", "Kowalski");

        Company company1 = new Company("Software Machines");
        Company company2 = new Company("Computer Machines");
        Company company3 = new Company("Microsoft");

        employee1.getCompanies().add(company1);
        employee1.getCompanies().add(company2);
        employee2.getCompanies().add(company2);
        employee3.getCompanies().add(company3);

        company1.getEmployees().add(employee1);
        company2.getEmployees().add(employee1);
        company2.getEmployees().add(employee2);
        company3.getEmployees().add(employee3);

        controller.saveEmployee(employee1);
        controller.saveEmployee(employee2);
        controller.saveEmployee(employee3);

        controller.saveCompany(company1);
        controller.saveCompany(company2);
        controller.saveCompany(company3);

        //When
        List<Employee> employeesByName = controller.retrieveEmployeesByName("%nowa%");

        //Then
        assertEquals(2, employeesByName.size());

        //CleanUp
        controller.deleteEmployee(employee1);
        controller.deleteEmployee(employee2);
        controller.deleteEmployee(employee3);

        controller.deleteCompany(company1);
        controller.deleteCompany(company2);
        controller.deleteCompany(company3);
    }

//    @Test
//    public void cleanup(){
//        controller.deleteAll();
//    }

}
