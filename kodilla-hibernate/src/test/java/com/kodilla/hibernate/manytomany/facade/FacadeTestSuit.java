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
        Company company1 = new Company("Software Machines");
        Company company2 = new Company("Computer Machines");
        Company company3 = new Company("Microsoft");

        controller.saveCompany(company1);
        controller.saveCompany(company2);
        controller.saveCompany(company3);

        //When
        List<Company> companiesByName = controller.retrieveCompaniesByName("%machi%");

        //Then
        assertEquals(2, companiesByName.size());

        //CleanUp
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

        controller.saveEmployee(employee1);
        controller.saveEmployee(employee2);
        controller.saveEmployee(employee3);

        //When
        List<Employee> employeesByName = controller.retrieveEmployeesByName("%nowa%");

        //Then
        assertEquals(2, employeesByName.size());

        //CleanUp
        controller.deleteEmployee(employee1);
        controller.deleteEmployee(employee2);
        controller.deleteEmployee(employee3);
    }

//    @Test
//    public void cleanup(){
//        controller.deleteAll();
//    }

}
