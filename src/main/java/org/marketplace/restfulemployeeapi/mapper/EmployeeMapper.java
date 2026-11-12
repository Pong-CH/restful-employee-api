package org.marketplace.restfulemployeeapi.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.marketplace.restfulemployeeapi.domain.Employee;
import org.marketplace.restfulemployeeapi.dto.CreateEmployeeRequest;
import org.marketplace.restfulemployeeapi.dto.EmployeeResponse;
import org.marketplace.restfulemployeeapi.dto.UpdateEmployeeRequest;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    // Map from Domain to DTO
    EmployeeResponse toResponse(Employee employee);

    // Map from DTO to domain
    Employee fromCreateEmployeeRequest(CreateEmployeeRequest employeeRequest);


    @BeanMapping(
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )
    void updateEntity(
            @MappingTarget Employee employee,
                UpdateEmployeeRequest updateEmployeeRequest
    );
}
