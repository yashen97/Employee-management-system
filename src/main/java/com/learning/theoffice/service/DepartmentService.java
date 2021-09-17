package com.learning.theoffice.service;

import com.learning.theoffice.dto.request.DepartmentRequest;
import com.learning.theoffice.dto.response.DepartmentResponse;

import java.util.List;

public interface DepartmentService {
    DepartmentResponse save(DepartmentRequest request);

    List<DepartmentResponse> saveAll(List<DepartmentRequest> departmentRequestList);


    List<DepartmentResponse> getAll();
}
