package com.learning.theoffice.configuration;

import com.learning.theoffice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling             //I forgot this configuration has to be stereotyped and scheduling needed to be enabled
public class Config {
    @Autowired
    EmployeeService employeeService;

    @Scheduled(cron = "0 0 12 * * ?")
    public void expireEmployee(){
        Integer count = employeeService.expireEmployee();

        System.out.println(count);

    }
}
