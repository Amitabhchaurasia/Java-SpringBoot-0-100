package com.springwebtutorial.springwebtutorila.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.springwebtutorial.springwebtutorila.dto.EmployeeDTO;
import com.springwebtutorial.springwebtutorila.entity.EmployeeEntity;
import com.springwebtutorial.springwebtutorila.repository.EmployeeRepository;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper ;

    EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper){ 
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmpById(long id) {
        EmployeeEntity ee = employeeRepository.findById(id).orElse(null);
        return modelMapper.map(ee, EmployeeDTO.class);
    }

    
    public List<EmployeeDTO> getAllEmp(Integer age, String sortBy) {
        List<EmployeeEntity> ee = employeeRepository.findAll();
        return ee.stream().map(entity->modelMapper.map(entity, EmployeeDTO.class)).toList();
    }

    public EmployeeDTO addEmp(EmployeeDTO employeeDTO) {
        EmployeeEntity tosaveEE=modelMapper.map(employeeDTO, EmployeeEntity.class);
        employeeRepository.save(tosaveEE);
        return modelMapper.map(tosaveEE, EmployeeDTO.class);
    }

}
