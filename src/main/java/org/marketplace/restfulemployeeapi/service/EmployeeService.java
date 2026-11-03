package org.marketplace.restfulemployeeapi.service;

import org.marketplace.restfulemployeeapi.domain.Employee;
import org.marketplace.restfulemployeeapi.dto.CreateEmployeeRequest;
import org.marketplace.restfulemployeeapi.dto.EmployeeResponse;
import org.marketplace.restfulemployeeapi.dto.UpdateEmployeeRequest;

import java.util.List;

public interface EmployeeService {

    //CRUD, Create, Read, Update, Delete
    List<EmployeeResponse> getAll();
    EmployeeResponse getEmployeeById(Integer id);

    EmployeeResponse createEmployee(CreateEmployeeRequest employeeRequest);

    List<EmployeeResponse> searchEmployees(String name);

    EmployeeResponse updateEmployeeById(Integer id, UpdateEmployeeRequest updateEmployeeRequest);

    void deleteEmployeeById(Integer id);

}
