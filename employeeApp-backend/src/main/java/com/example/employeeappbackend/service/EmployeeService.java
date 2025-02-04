package com.example.employeeappbackend.service;

import com.example.employeeappbackend.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

     List<EmployeeDTO> getAllEmployees();

     EmployeeDTO getEmployeeById(long id);

    void deleteEmployeById(long id);

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO updateEmployeById(long id, EmployeeDTO employeeDTO);
}
