package com.learning.theoffice.service.Impl;

import com.learning.theoffice.dto.request.EmployeeRequest;
import com.learning.theoffice.dto.request.EmployeeUpdateRequest;
import com.learning.theoffice.dto.response.EmployeeResponse;
import com.learning.theoffice.entity.Department;
import com.learning.theoffice.entity.Employee;
import com.learning.theoffice.repository.EmployeeRepo;
import com.learning.theoffice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.SecureRandom;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public EmployeeResponse save(EmployeeRequest employeeRequest) {
        Employee employee=new Employee();

        employee.setId(employeeRequest.getId());
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

    @Override
    public List<EmployeeResponse> getAll() {
        return employeeRepo.findAll().stream().map(EmployeeServiceImpl::convert).collect(Collectors.toList());
    }

    @Override
    public EmployeeResponse getByRefNo(String referenceNo) {
        Employee employee= employeeRepo.findByGeneratedNo(referenceNo);
        return convert(employee);
    }

    @Override
    public List<Employee> saveAll(List<Employee> employeeList) {
        return employeeRepo.saveAll(employeeList);
    }

    @Override
    public EmployeeResponse update(EmployeeUpdateRequest employeeUpdateRequest) {
        Employee selected= employeeRepo.findByGeneratedNo(employeeUpdateRequest.getGeneratedNo());

        selected.setId(selected.getId());
        selected.setName(employeeUpdateRequest.getName());
        selected.setGeneratedNo(selected.getGeneratedNo());
        selected.setPosition(employeeUpdateRequest.getPosition());
        selected.setRecordCreatedDate(selected.getRecordCreatedDate());
        selected.setCreatedBy(selected.getCreatedBy());
        selected.setModifiedDate(new Date());
        selected.setModifiedBy(selected.getModifiedBy());
        selected.setStatus(employeeUpdateRequest.getStatus()==null? 1:employeeUpdateRequest.getStatus());

        Department department=new Department();
        department.setId(employeeUpdateRequest.getDepartmentId());
        selected.setDepartment(department);

        Employee emp= employeeRepo.save(selected);
        return convert(emp);

    }

    @Override
    public List<EmployeeResponse> getActiveList() {
        return employeeRepo.findByStatusOrderByIdAsc(1)
                .stream().map(EmployeeServiceImpl::convert).collect(Collectors.toList());
    }

    @Override
    public Integer delete(String refNo) {
        Employee employee = employeeRepo.findByGeneratedNo(refNo);
        employee.setStatus(0);
        employeeRepo.save(employee);
        return 0;
    }

    @Override
    @Transactional
    public Integer expireEmployee() {
        List<Employee> expiredList= employeeRepo.findByStatusOrderByIdAsc(0);

        Integer count=0;

        for(Employee employee:expiredList){
            employeeRepo.delete(employee);
            count++;
        }
        return count;
    }

//    @Override
//    @Transactional
//    public Integer expireEmployee() {
//        List<Employee> expiredList= employeeRepo.findByStatusOrderByIdAsc(0);
//
//        Integer count=0;
//
//        for(Employee employee:expiredList){
//
//        }
//        return null;
//    }


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
        employeeResponse.setCreatedBy(employee.getCreatedBy());
        employeeResponse.setModifiedDate(employee.getModifiedDate());
        employeeResponse.setModifiedBy(employee.getModifiedBy());
        employeeResponse.setStatus(employee.getStatus());
        employeeResponse.setDepartmentName(employee.getDepartment().getName());
        return employeeResponse;
    }
}
