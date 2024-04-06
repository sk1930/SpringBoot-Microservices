package sk.microservices.departmentservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sk.microservices.departmentservice.dto.DepartmentDto;
import sk.microservices.departmentservice.entity.Department;


//41. Using MapStruct Library
@Mapper
public interface AutoDepartmentMapper {

    AutoDepartmentMapper Mapper = Mappers.getMapper(AutoDepartmentMapper.class);
    DepartmentDto maptoDepartmentDto(Department department);

    Department mapToDepartment(DepartmentDto departmentDto);
}
