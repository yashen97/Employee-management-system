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
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepo departmentRepo;

    @Override
    public DepartmentResponse save(DepartmentRequest request) {      //convert response to entity and save
        Department department=new Department();

        //department.setId(request.getId());
        department.setCode(request.getCode());
        department.setName(request.getName());
        department.setLocation(request.getLocation());
        department.setRecordCreatedDate(new Date());
        Department save=departmentRepo.save(department);      //save
        return convert(department);                           //convert to response func
    }

    @Override
    public List<Department> saveAll(List<Department> departmentList) {
        return departmentRepo.saveAll(departmentList);
    }



    @Override
    public List<DepartmentResponse> getAll() {
        return departmentRepo.findAll()
                .stream().map(DepartmentServiceImpl::convert).collect(Collectors.toList());
    }




    private static DepartmentResponse convert(Department department){       //convert entity to response
        DepartmentResponse departmentResponse=new DepartmentResponse();
        departmentResponse.setId(department.getId());
        departmentResponse.setCode(department.getCode());
        departmentResponse.setName(department.getName());
        departmentResponse.setLocation(department.getLocation());
        departmentResponse.setRecordCreatedDate(department.getRecordCreatedDate());
        return  departmentResponse;
    }



}
