package com.example.Employee.App.Controller;

import java.net.URI;

import com.example.Employee.App.DAO.EmployeeDAO;
import com.example.Employee.App.Entity.Employee;
import com.example.Employee.App.Storage.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping(path = "/", produces = "application/json")
    public Employees getEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        Integer id = employeeDAO.getAllEmployees().getEmployeeList().size() + 1;

        employee.setId(id);

        employeeDAO.addEmployee(employee);

        URI location
                = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(
                        employee.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .build();
    }
}
