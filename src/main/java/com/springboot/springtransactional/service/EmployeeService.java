package com.springboot.springtransactional.service;

import com.springboot.springtransactional.dto.EmployeeRequestDto;
import com.springboot.springtransactional.entity.Department;
import com.springboot.springtransactional.entity.Employee;
import com.springboot.springtransactional.repository.DepartmentRepository;
import com.springboot.springtransactional.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final DepartmentRepository departmentRepository;

    @Transactional
    public String saveEmployee(EmployeeRequestDto employeeRequestDto){

        Department department = new Department();
        department.setDepartmentName(employeeRequestDto.getDepartmentName());
        department.setDepartmentCode(employeeRequestDto.getDepartmentName());

        Long departmentId = departmentRepository.save(department).getDepartmentId();

        //Employee employee = new Employee();
        Employee employee = null;

        employee.setEmpName(employeeRequestDto.getEmpName());
        employee.setEmail(employeeRequestDto.getEmail());
        employee.setDepartmentId(departmentId);

        employeeRepository.save(employee);

        return "Employee is saved with Employee ID : " + employee.getEmployeeId().toString();

    }
}
