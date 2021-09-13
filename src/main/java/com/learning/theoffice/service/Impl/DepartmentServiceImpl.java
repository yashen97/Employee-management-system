package com.learning.theoffice.service.Impl;

import com.learning.theoffice.dto.request.DepartmentRequest;
import com.learning.theoffice.dto.response.DepartmentResponse;
import com.learning.theoffice.entity.Department;
import com.learning.theoffice.repository.DepartmentRepo;
import com.learning.theoffice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepo departmentRepo;

    @Override
    public DepartmentResponse save(DepartmentRequest request) {
        Department department=new Department();

        department.setId(request.getId());
        department.setCode(request.getCode());
        department.setLocation(request.getLocation());
        department.setRecordCreatedDate(new Date());
        Department save=departmentRepo.save(department);
        return convert(department);
    }

    @Override
    public List<DepartmentResponse> saveAll(List<DepartmentRequest> departmentRequestList) {
        return null;
    }

    private static DepartmentResponse convert(Department department){       //convert entity to response
        DepartmentResponse departmentResponse=new DepartmentResponse();
        departmentResponse.setId(department.getId());
        departmentResponse.setCode(department.getCode());
        departmentResponse.setLocation(department.getLocation());
        departmentResponse.setRecordCreatedDate(department.getRecordCreatedDate());
        return  departmentResponse;
    }

}
