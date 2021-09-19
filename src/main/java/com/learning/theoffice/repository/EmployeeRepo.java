package com.learning.theoffice.repository;

import com.learning.theoffice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    Employee findByGeneratedNo(String refNo);
    List<Employee> findByStatusOrderByIdAsc(Integer status);
}
