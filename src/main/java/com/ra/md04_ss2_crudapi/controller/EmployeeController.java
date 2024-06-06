package com.ra.md04_ss2_crudapi.controller;

import com.ra.md04_ss2_crudapi.entity.Employee;
import com.ra.md04_ss2_crudapi.request.EmployeeRequest;
import com.ra.md04_ss2_crudapi.service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
     return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK) ;
    }
    @GetMapping("/{enployyeID}")
    public ResponseEntity<Employee> getAllEmployeeByID(@PathVariable int enployyeID) {
        return new ResponseEntity<>(employeeService.getEmployeeById(enployyeID), HttpStatus.OK) ;
    }
    @GetMapping("/getByName/{employeeName}")
    public ResponseEntity<Employee> getEmployeeByName(@PathVariable String employeeName) {
        return new ResponseEntity<>(employeeService.getEmployeeByName(employeeName), HttpStatus.OK) ;
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.OK) ;
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.OK) ;
    }

    @DeleteMapping("/{employeeID}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int employeeID) {
        employeeService.deleteEmployee(employeeID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT) ;
    }

    @GetMapping("/serchAndSort")
    public ResponseEntity<List<Employee>> serchAndSort(@RequestBody EmployeeRequest employeeRequest) {
        List<Employee> employees = employeeService.findEmployeesByFullNameAndSorting(employeeRequest.getName(),employeeRequest.getPage()-1,employeeRequest.getItemPage(),employeeRequest.getSortBy(),employeeRequest.getDirection()).getContent();
    return new ResponseEntity<>(employees, HttpStatus.OK) ;
    }

    @GetMapping("/searchSalary")
    public ResponseEntity<List<Employee>> serchSalary(@RequestParam("max") Double max,@RequestParam("min") Double min) {
        return new ResponseEntity<>(employeeService.findEmployeeBySalaryBetween(min,max), HttpStatus.OK) ;
    }
}
