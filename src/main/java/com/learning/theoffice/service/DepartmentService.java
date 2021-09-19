package com.learning.theoffice.service;

import com.learning.theoffice.dto.request.DepartmentRequest;
import com.learning.theoffice.dto.response.DepartmentResponse;
import com.learning.theoffice.entity.Department;

import java.util.List;

public interface DepartmentService {
    DepartmentResponse save(DepartmentRequest request);

    
    List<DepartmentResponse> getAll();

    List<Department> saveAll(List<Department> departmentList);
}
