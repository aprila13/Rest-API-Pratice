package com.example.Employee.App.DAO;

import com.example.Employee.App.Entity.Employee;
import com.example.Employee.App.Storage.Employees;
import org.springframework.stereotype.Repository;

//DAO: Creates an object of the storage class to store employees
@Repository
public class EmployeeDAO {

    //"list" is an instance of the storage class Employees
    private static Employees list = new Employees();

    static {
        list.getEmployeeList().add(
                new Employee(
                        1,
                        "April",
                        "Craig",
                        "april@gmail.com"));

        list.getEmployeeList().add(
                new Employee(
                        2,
                        "Jane",
                        "Doe",
                        "jane@aol.com"));

        list.getEmployeeList().add(
                new Employee(
                        3,
                        "Paul",
                        "Bunyan",
                        "paul@yahoo.com"));
    }

    public Employees getAllEmployees() {
        return list;
    }

    public void addEmployee(Employee employee) {
        list.getEmployeeList().add(employee);
    }
}
