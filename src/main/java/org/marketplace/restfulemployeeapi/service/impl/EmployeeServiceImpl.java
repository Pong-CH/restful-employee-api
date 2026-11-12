package org.marketplace.restfulemployeeapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.marketplace.restfulemployeeapi.domain.Employee;
import org.marketplace.restfulemployeeapi.dto.CreateEmployeeRequest;
import org.marketplace.restfulemployeeapi.dto.EmployeeResponse;
import org.marketplace.restfulemployeeapi.dto.UpdateEmployeeRequest;
import org.marketplace.restfulemployeeapi.mapper.EmployeeMapper;
import org.marketplace.restfulemployeeapi.repository.EmployeeRepository;
import org.marketplace.restfulemployeeapi.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;


    @Override
    public List<EmployeeResponse> getAll() {

        List<Employee> employees = repository.findAll();

        return employees
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public EmployeeResponse getEmployeeById(Integer id) {

        Employee foundEmployee = repository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Employee has not found"
                        )
                );

        return mapper.toResponse(foundEmployee);
    }

    @Override
    public EmployeeResponse createEmployee(CreateEmployeeRequest employeeRequest) {

        if(repository.existsByEmail(employeeRequest.email())){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Email is already exist"
            );
        }

        Employee employee = mapper.fromCreateEmployeeRequest(employeeRequest);
        employee.setIsActive(Boolean.TRUE);

        repository.save(employee);

        return mapper.toResponse(employee);
    }

    @Override
    public List<EmployeeResponse> searchEmployees(String name) {

        List<Employee> employees = repository
                .findAllByNameContainingIgnoreCase(name);

        return employees
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public EmployeeResponse updateEmployeeById(Integer id, UpdateEmployeeRequest updateEmployeeRequest) {

        Employee employee = repository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Employee has been found"
                        )
                );

        if(repository.existsByEmail(updateEmployeeRequest.email())){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Email is already exist"
            );
        }


        mapper.updateEntity(employee, updateEmployeeRequest);

        Employee updateEmployee = repository.save(employee);

        return mapper.toResponse(updateEmployee);
    }

    @Override
    public void deleteEmployeeById(Integer id) {

        if (!repository.existsById(id)){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Employee not been found"
            );
        }

        repository.deleteById(id);
    }
}
