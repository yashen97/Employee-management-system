package com.learning.theoffice.service.Impl;

import com.learning.theoffice.repository.EmployeeRepo;
import com.learning.theoffice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;
}
