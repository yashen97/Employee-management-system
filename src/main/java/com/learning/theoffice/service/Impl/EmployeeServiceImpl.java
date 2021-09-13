package com.learning.theoffice.service.Impl;

import com.learning.theoffice.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceImpl {
    @Autowired
    EmployeeRepo employeeRepo;
}
