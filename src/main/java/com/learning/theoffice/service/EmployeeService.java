package com.learning.theoffice.service;

import com.learning.theoffice.dto.request.EmployeeRequest;
import com.learning.theoffice.dto.request.EmployeeUpdateRequest;
import com.learning.theoffice.dto.response.EmployeeResponse;
import com.learning.theoffice.entity.Employee;

import java.util.List;

public interface EmployeeService {

    EmployeeResponse save(EmployeeRequest employeeRequest);

    List<EmployeeResponse> getAll();

    EmployeeResponse getByRefNo(String referenceNo);

    List<Employee> saveAll(List<Employee> employeeList);

    EmployeeResponse update(EmployeeUpdateRequest employeeUpdateRequest);

    List<EmployeeResponse> getActiveList();

    Integer delete(String refNo);

    Integer expireEmployee();
}
