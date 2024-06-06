package com.ra.md04_ss2_crudapi.service.impl;

import com.ra.md04_ss2_crudapi.entity.Employee;
import com.ra.md04_ss2_crudapi.repository.EmployeeRepository;
import com.ra.md04_ss2_crudapi.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);

    }

    @Override
    public Employee updateEmployee(Employee employee) {
        employeeRepository.findById(employee.getId()).orElseThrow(()->new NoSuchElementException("Khong ton tai nhan vien"));
        return    employeeRepository.save(employee);

    }

    @Override
    public void deleteEmployee(Integer employeeID) {
        employeeRepository.deleteById(employeeID);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElseThrow(()->new NoSuchElementException("Khong ton tai nhan vien"));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeByName(String name) {
        return employeeRepository.findEmployeeByFullName(name);
    }

    @Override
    public List<Employee> findEmployeeBySalaryBetween(Double min, Double max) {
        return employeeRepository.findEmployeeBySalaryBetween(min, max);
    }

    public Page<Employee> findEmployeesByFullNameAndSorting(String searchName, Integer page, Integer itemPage, String orderBy, String direction) {
        Pageable pageable =null;
        if(orderBy!=null && !orderBy.isEmpty()){
            // co sap xep
            Sort sort = null;
            switch (direction){
                case "ASC":
                    sort = Sort.by(orderBy).ascending();
                    break;
                case "DESC":
                    sort = Sort.by(orderBy).descending();
                    break;
            }
            pageable = PageRequest.of(page, itemPage,sort);
        }else{
            //khong sap xep
            pageable = PageRequest.of(page, itemPage);
        }

        //xu ly ve tim kiem
        if(searchName!=null && !searchName.isEmpty()){
            //co tim kiem
            return employeeRepository.findEmployeesByFullNameAndSorting(searchName,pageable);
        }else{
            //khong tim kiem
            return employeeRepository.findAll(pageable);
        }
    }
}
