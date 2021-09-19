package com.learning.theoffice.controller;

import com.learning.theoffice.dto.request.EmployeeRequest;
import com.learning.theoffice.dto.request.EmployeeUpdateRequest;
import com.learning.theoffice.dto.response.EmployeeResponse;
import com.learning.theoffice.entity.Employee;
import com.learning.theoffice.service.EmployeeService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("all")
    public List<Employee> saveAll(@RequestBody List<Employee> employeeList){
        return employeeService.saveAll(employeeList);
    }

    @GetMapping("")
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees(){
        List<EmployeeResponse> responseList=employeeService.getAll();
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("{refNo}")
    public ResponseEntity<EmployeeResponse> getByRefNo(@PathVariable("refNo") String referenceNo){
        EmployeeResponse response=employeeService.getByRefNo(referenceNo);
        return ResponseEntity.ok(response);
    }

    @PutMapping("{refNo}")
    public ResponseEntity<EmployeeResponse> updateByEmpRefNo(@RequestBody EmployeeUpdateRequest employeeUpdateRequest){
        EmployeeResponse response=employeeService.update(employeeUpdateRequest);
        return ResponseEntity.ok(response);

    }

    @GetMapping("getActive")
    public ResponseEntity<List<EmployeeResponse>> getActiveList(){
       List<EmployeeResponse> response=employeeService.getActiveList();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{refNo}")
    public ResponseEntity<Integer> delete(@PathVariable String refNo){
        Integer isDeleted=employeeService.delete(refNo);
        return ResponseEntity.ok(isDeleted);
    }


}
