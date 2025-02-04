package com.example.employeeappbackend.service;

import com.example.employeeappbackend.dto.EmployeeDTO;
import com.example.employeeappbackend.model.Employee;
import com.example.employeeappbackend.repository.EmployeeRepository;
import com.example.employeeappbackend.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;


   public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

/*
    @Override
    public List<Employee> getAllEmployees() {
        System.out.println("getAllEmployees : ");
        return employeeRepository.findAll();
    }

 */

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        System.out.println("getAllEmployees : ");
        List<Employee> employee = employeeRepository.findAll();
        return employeeMapper.toDto(employee);
    }



    @Override
    public EmployeeDTO getEmployeeById(long id) {
        return employeeMapper.toDto(employeeRepository.findById(id).get());
    }

    @Override
    public void deleteEmployeById(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEntity(employeeDTO);
        return employeeMapper.toDto(employeeRepository.save(employee));
    }

    @Override
    public EmployeeDTO updateEmployeById(long id, EmployeeDTO employeeDTO) {

        Employee updatedEmployee = employeeMapper.updateEntityFromDto(employeeDTO, employeeRepository.findById(id).get());
        return employeeMapper.toDto(employeeRepository.save(updatedEmployee));
    }


}