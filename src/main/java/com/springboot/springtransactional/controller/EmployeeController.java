package com.springboot.springtransactional.controller;

import com.springboot.springtransactional.dto.EmployeeRequestDto;
import com.springboot.springtransactional.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/employee")
    public String saveEmployee(@RequestBody EmployeeRequestDto employeeRequestDto){
        return employeeService.saveEmployee(employeeRequestDto);
    }

}
