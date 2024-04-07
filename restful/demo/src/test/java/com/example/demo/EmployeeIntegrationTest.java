package com.example.demo;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EmployeeIntegrationTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testCreateReadDelete() {
        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setRole("Developer");

        employeeRepository.save(employee);

        Iterable<Employee> employees = employeeRepository.findAll();
        assertThat(employees).extracting(Employee::getName).contains("John Doe");

        employeeRepository.deleteAll();
        assertThat(employeeRepository.findAll()).isEmpty();
    }
}