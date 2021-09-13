package com.learning.theoffice.repository;

import com.learning.theoffice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
}
