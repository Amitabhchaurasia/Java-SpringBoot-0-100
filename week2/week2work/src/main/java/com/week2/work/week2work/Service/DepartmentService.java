package com.week2.work.week2work.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.week2.work.week2work.DTO.DepartmentDto;
import com.week2.work.week2work.DepartmentEntity.DepartmentEntity;

@Service
public class DepartmentService {

    @Autowired
    private ModelMapper modelMapper;

    public DepartmentDto addData(DepartmentDto departmentDTO) {
        DepartmentEntity departmentEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        // Save departmentEntity to the database or perform other business logic
        return modelMapper.map(departmentEntity, DepartmentDto.class);
    }
}
