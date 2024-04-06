package sk.microservices.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sk.microservices.departmentservice.dto.DepartmentDto;
import sk.microservices.departmentservice.entity.Department;
import sk.microservices.departmentservice.mapper.AutoDepartmentMapper;
import sk.microservices.departmentservice.repository.DepartmentRepository;
import sk.microservices.departmentservice.service.DepartmentService;

@Service
@AllArgsConstructor
/*86. DepartmentService - Create Department JPA Entity and Spring Data JPA Repository
 */
public class DepartmentServiceImpl implements DepartmentService {
    /*
Well, typically we need to use @Autowired annotation to inject the dependency
But spring 4.3 onwards, whenever there is a spring bean, it has a single parameterized constructor
then we can omit using @Autowired annotation.*/


    private DepartmentRepository departmentRepository;


    //ModelMapper and MapStruct Libraries
    // in notes
    private ModelMapper modelMapper;


    /*86. DepartmentService - Create Department JPA Entity and Spring Data JPA Repository
     */
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {


        /*Department department = new Department(departmentDto.getUuid(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
                );

                commented these lines to use modelMapper
         */
        Department department = modelMapper.map(departmentDto,Department.class);
        Department savedDepartment = departmentRepository.save(department);


        /*
        DepartmentDto savedDepartmentDto = new DepartmentDto(
                savedDepartment.getUuid(),
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDescription(),
                savedDepartment.getDepartmentCode()
        );
                        commented these lines to use modelMapper

         */
        /*

        //ModelMapper and MapStruct Libraries in notes
        // this is using ModelMapper class
        DepartmentDto savedDepartmentDto = modelMapper.map(savedDepartment, DepartmentDto.class);

         */

        //41. Using MapStruct Library
        DepartmentDto savedDepartmentDto = AutoDepartmentMapper.Mapper.maptoDepartmentDto(savedDepartment);

        return savedDepartmentDto ;
    }

    //88. DepartmentService - Build Get Department REST API
    public DepartmentDto getDepartmentByCode(String departmentCode){
        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        /*
        DepartmentDto departmentDto = new DepartmentDto(
                department.getUuid(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
                                commented these lines to use modelMapper

         */

        /*
         //ModelMapper and MapStruct Libraries in notes
        // this is using ModelMapper class

        DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);
          */

        //41. Using MapStruct Library
        DepartmentDto departmentDto = AutoDepartmentMapper.Mapper.maptoDepartmentDto(department);

        return departmentDto;

    }

}
