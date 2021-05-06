package com.simonov.kirill.mvc_hibernate_aop.service;

import com.simonov.kirill.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployee(int id);
    void saveEmployee(Employee employee);
    void delete(int id);
}
