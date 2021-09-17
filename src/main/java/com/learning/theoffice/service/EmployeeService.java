package com.learning.theoffice.service;

import com.learning.theoffice.dto.request.EmployeeRequest;
import com.learning.theoffice.dto.response.EmployeeResponse;

public interface EmployeeService {

    EmployeeResponse save(EmployeeRequest employeeRequest);
}
