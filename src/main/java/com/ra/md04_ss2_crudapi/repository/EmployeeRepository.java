package com.ra.md04_ss2_crudapi.repository;

import com.ra.md04_ss2_crudapi.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("select e from Employee e where e.fullName like concat('%',:fullName,'%') ")
    Employee findEmployeeByFullName(String fullName);

    @Query("select e from Employee e where e.salary between :min and :max")
    List<Employee> findEmployeeBySalaryBetween(double min, double max);

    @Query("select e from Employee e where e.fullName like concat('%',:fullName,'%') ")
    Page<Employee> findEmployeesByFullNameAndSorting(String fullName, Pageable pageable);




}
