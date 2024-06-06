package com.ra.md04_ss2_crudapi.service;

import com.ra.md04_ss2_crudapi.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    public Employee addEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(Integer employeeID);
    public Employee getEmployeeById(int id);
    public List<Employee> getAllEmployees();
    Employee getEmployeeByName(String name);
    List<Employee> findEmployeeBySalaryBetween(Double min, Double max);
}
