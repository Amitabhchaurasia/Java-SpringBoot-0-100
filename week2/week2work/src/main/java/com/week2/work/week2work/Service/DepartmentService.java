package com.week2.work.week2work.Service;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.week2.work.week2work.DTO.DepartmentDto;
import com.week2.work.week2work.DepartmentEntity.DepartmentEntity;
import com.week2.work.week2work.Repository.DepartmentRepo;

@Service
public class DepartmentService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private DepartmentRepo departmentRepository;

    public DepartmentDto addData(DepartmentDto departmentDTO) {
        DepartmentEntity departmentEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        DepartmentEntity savedDepartmentEntity = departmentRepository.save(departmentEntity);
        return modelMapper.map(savedDepartmentEntity, DepartmentDto.class);
    }

    public List<DepartmentDto> getAll() {
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
        return departmentEntities.stream().map(entity->modelMapper.map(entity, DepartmentDto.class)).toList();
    }
}
