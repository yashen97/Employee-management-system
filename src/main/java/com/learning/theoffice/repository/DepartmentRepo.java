package com.learning.theoffice.repository;

import com.learning.theoffice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department,Long> {
}
