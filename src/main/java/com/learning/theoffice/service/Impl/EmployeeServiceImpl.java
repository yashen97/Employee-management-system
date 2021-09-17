package com.learning.theoffice.service.Impl;

import com.learning.theoffice.dto.request.EmployeeRequest;
import com.learning.theoffice.dto.response.EmployeeResponse;
import com.learning.theoffice.entity.Department;
import com.learning.theoffice.entity.Employee;
import com.learning.theoffice.repository.EmployeeRepo;
import com.learning.theoffice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public EmployeeResponse save(EmployeeRequest employeeRequest) {
        Employee employee=new Employee();

        //employee.setId(employeeRequest.getId());
        employee.setName(employeeRequest.getName());
        employee.setGeneratedNo(generateReference());
        employee.setName(employeeRequest.getName());
        employee.setPosition(employeeRequest.getPosition());
        employee.setRecordCreatedDate(new Date());
        employee.setCreatedBy(employeeRequest.getCreatedBy());
        employee.setModifiedDate(new Date());
        employee.setModifiedBy(employeeRequest.getModifiedBy());
        employee.setStatus(employeeRequest.getStatus()==null? 1:employeeRequest.getStatus());

        Department department=new Department();
        department.setId(employeeRequest.getDepartmentId());
        employee.setDepartment(department);

        Employee emp= employeeRepo.save(employee);
        return convert(emp);
    }

    static String generateReference() {
        String ref = "";
        String result = new SecureRandom().ints(0, 36)
                .mapToObj(i -> Integer.toString(i, 36))
                .map(String::toUpperCase).distinct().limit(16).collect(Collectors.joining())
                .replaceAll("([A-Z0-9]{4})", "$1-").substring(0, 19).replace("-", "");
        ref = result;
        return ref;
    }

    private static EmployeeResponse convert(Employee employee){
        EmployeeResponse employeeResponse=new EmployeeResponse();

        employeeResponse.setId(employee.getId());
        employeeResponse.setGeneratedNo(employee.getGeneratedNo());
        employeeResponse.setName(employee.getName());
        employeeResponse.setPosition(employee.getPosition());
        employeeResponse.setRecordCreatedDate(employee.getRecordCreatedDate());
        employeeResponse.setCreatedBy(employeeResponse.getCreatedBy());
        employeeResponse.setModifiedDate(employee.getModifiedDate());
        employeeResponse.setModifiedBy(employee.getModifiedBy());
        employeeResponse.setStatus(employee.getStatus());
        employeeResponse.setDepartmentName(employee.getDepartment().getName());
        return employeeResponse;
    }
}
