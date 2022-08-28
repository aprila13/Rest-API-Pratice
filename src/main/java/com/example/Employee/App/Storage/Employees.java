package com.example.Employee.App.Storage;

import com.example.Employee.App.Entity.Employee;

import java.util.ArrayList;
import java.util.List;

//Class stores all employees
public class Employees {

    private List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
        if (employeeList == null) {
            employeeList = new ArrayList<>();
        }
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
