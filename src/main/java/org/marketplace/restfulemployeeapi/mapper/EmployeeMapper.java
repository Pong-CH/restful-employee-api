package org.marketplace.restfulemployeeapi.mapper;

import org.mapstruct.Mapper;
import org.marketplace.restfulemployeeapi.domain.Employee;
import org.marketplace.restfulemployeeapi.dto.CreateEmployeeRequest;
import org.marketplace.restfulemployeeapi.dto.EmployeeResponse;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    // Map from Domain to DTO
    EmployeeResponse toResponse(Employee employee);

    // Map from DTO to domain
    Employee fromCreateEmployeeRequest(CreateEmployeeRequest employeeRequest);
}
