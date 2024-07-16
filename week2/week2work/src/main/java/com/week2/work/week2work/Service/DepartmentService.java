package com.week2.work.week2work.Service;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.week2.work.week2work.DTO.DepartmentDto;
import com.week2.work.week2work.DepartmentEntity.DepartmentEntity;
import com.week2.work.week2work.Repository.DepartmentRepo;

@Service
public class DepartmentService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private DepartmentRepo departmentRepository;
    private ObjectMapper objectMapper = new ObjectMapper();

    
    public DepartmentDto addData(DepartmentDto departmentDTO) {
        DepartmentEntity departmentEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        DepartmentEntity savedDepartmentEntity = departmentRepository.save(departmentEntity);
        return modelMapper.map(savedDepartmentEntity, DepartmentDto.class);
    }

    public List<DepartmentDto> getAll() {
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
         return departmentEntities.stream().map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDto.class)).toList();
    }

    public DepartmentDto getById(Long id) {
        DepartmentEntity departmentEntity = departmentRepository.findById(id).orElse(null);
        return modelMapper.map(departmentEntity, DepartmentDto.class);
    }

    public String deleteData(Long id) {
        departmentRepository.deleteById(id);
        return "Data Deleted";
    }

    public DepartmentDto updateData(Map<String, Object> updates,Long id) throws JsonMappingException {
        DepartmentEntity de=departmentRepository.findById(id).orElse(null);
        if (de == null) {
            return null; 
        }
        objectMapper.updateValue(de, updates);
        DepartmentEntity updatedDepartmentEntity = departmentRepository.save(de);
        return modelMapper.map(updatedDepartmentEntity, DepartmentDto.class);
        
    }
}
