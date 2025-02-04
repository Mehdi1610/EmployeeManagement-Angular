package com.example.employeeappbackend.TestControllerEmployee;

import com.example.employeeappbackend.dto.EmployeeDTO;
import com.example.employeeappbackend.mapper.EmployeeMapper;
import com.example.employeeappbackend.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

//  AJOUTER LA DEPENDANCE DES TESTS MOKITO
@SpringBootTest
    public class EmployeeMapperTest {

        @Autowired
        private EmployeeMapper employeeMapper;

        @Test
        void testMapping() {
            Employee employee = new Employee();
            employee.setId(1L);
            employee.setFirstName("John");
            employee.setLastName("Doe");
            employee.setEmailaddress("john.doe@example.com");

            EmployeeDTO dto = employeeMapper.toDto(employee);

            assertNotNull(dto);
            assertEquals(employee.getId(), dto.getId());
            assertEquals(employee.getFirstName(), dto.getFirstName());
            assertEquals(employee.getLastName(), dto.getLastName());
            assertEquals(employee.getEmailaddress(), dto.getEmail());
        }
    }

