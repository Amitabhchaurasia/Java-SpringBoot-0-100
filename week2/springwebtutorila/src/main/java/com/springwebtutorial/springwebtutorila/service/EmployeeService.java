package com.springwebtutorial.springwebtutorila.service;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springwebtutorial.springwebtutorila.dto.EmployeeDTO;
import com.springwebtutorial.springwebtutorila.entity.EmployeeEntity;
import com.springwebtutorial.springwebtutorila.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private ObjectMapper objectMapper;
    private final EmployeeRepository employeeRepository;
    private ModelMapper modelMapper = new ModelMapper();

    EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmpById(long id) {
        EmployeeEntity ee = employeeRepository.findById(id).orElse(null);
        return modelMapper.map(ee, EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmp(Integer age, String sortBy) {
        List<EmployeeEntity> ee = employeeRepository.findAll();
        return ee.stream().map(entity -> modelMapper.map(entity, EmployeeDTO.class)).toList();
    }

    public EmployeeDTO addEmp(EmployeeDTO employeeDTO) {
        EmployeeEntity tosaveEE = modelMapper.map(employeeDTO, EmployeeEntity.class);
        employeeRepository.save(tosaveEE);
        return modelMapper.map(tosaveEE, EmployeeDTO.class);
    }

    public EmployeeDTO updateEmp(long id, EmployeeDTO employeeDTO) {
        EmployeeEntity ee = modelMapper.map(employeeDTO, EmployeeEntity.class);
        ee.setId(id);
        EmployeeEntity updatedEE = employeeRepository.save(ee);
        return modelMapper.map(updatedEE, EmployeeDTO.class);
    }

    public boolean deleteEmp(long id) {
        boolean exits = employeeRepository.existsById(id);
        if (exits) {
            employeeRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public EmployeeDTO patchEmp(Long id, Map<String, Object> updates) throws JsonMappingException {
        EmployeeEntity ee = employeeRepository.findById(id).orElse(null);
        if (ee == null) {
            return null;
        }
        objectMapper.updateValue(ee, updates);
        EmployeeEntity updatedEE = employeeRepository.save(ee);
        return modelMapper.map(updatedEE, EmployeeDTO.class);

    }

}
