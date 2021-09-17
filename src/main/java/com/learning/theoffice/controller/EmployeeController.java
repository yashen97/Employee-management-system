package com.learning.theoffice.controller;

import com.learning.theoffice.dto.request.EmployeeRequest;
import com.learning.theoffice.dto.response.EmployeeResponse;
import com.learning.theoffice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("post")
    public ResponseEntity<EmployeeResponse> save(@RequestBody EmployeeRequest employeeRequest){
        EmployeeResponse response=employeeService.save(employeeRequest);
        return ResponseEntity.ok(response);
    }
}
