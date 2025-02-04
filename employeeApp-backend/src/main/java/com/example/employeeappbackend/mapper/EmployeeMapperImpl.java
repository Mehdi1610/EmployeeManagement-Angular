package com.example.employeeappbackend.mapper;

import com.example.employeeappbackend.dto.EmployeeDTO;
import com.example.employeeappbackend.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapperImpl implements EmployeeMapper {


        @Override
        public Employee toEntity(EmployeeDTO employeeDTO) {
            if ( employeeDTO == null ) {
                return null;
            }

            String firstName = employeeDTO.getFirstName();
            String lastName = employeeDTO.getLastName();
            String emailaddress = employeeDTO.getEmail();



            return  new Employee( firstName, lastName, emailaddress );
        }

        @Override
        public EmployeeDTO toDto(Employee employee) {
            if ( employee == null ) {
                return null;
            }
            return new EmployeeDTO(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmailaddress());
        }

    @Override
    public Employee updateEntityFromDto(EmployeeDTO employeeDTO, Employee employee) {
        if (employeeDTO == null || employee == null) {
            return null;
        }

        if (employeeDTO.getFirstName() != null) {
            employee.setFirstName(employeeDTO.getFirstName());
        }

        if (employeeDTO.getLastName() != null) {
            employee.setLastName(employeeDTO.getLastName());
        }

        if (employeeDTO.getEmail() != null) {
            employee.setEmailaddress(employeeDTO.getEmail());
        }

        return employee;
    }

    @Override
        public List<EmployeeDTO> toDto(List<Employee> employees) {
            if ( employees == null ) {
                return null;
            }

            List<EmployeeDTO> list = new ArrayList<EmployeeDTO>( employees.size() );
            for ( Employee employee : employees ) {
                list.add( toDto( employee ) );
            }

            return list;
        }

        @Override
        public List<Employee> toEntity(List<EmployeeDTO> employeeDTO) {
            if ( employeeDTO == null ) {
                return null;
            }

            List<Employee> list = new ArrayList<Employee>( employeeDTO.size() );
            for ( EmployeeDTO employeeDTO1 : employeeDTO ) {
                list.add( toEntity( employeeDTO1 ) );
            }

            return list;
        }
    }

