package com.week2.work.week2work.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.week2.work.week2work.DTO.DepartmentDto;
import com.week2.work.week2work.Service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService ds;

    @GetMapping
    public List<DepartmentDto> getDepartment() {
        return ds.getAll();
    }

    @GetMapping("/{id}")
    public DepartmentDto getDepartmentById(@PathVariable Long id) {
        return ds.getById(id);
    }

    @PostMapping
    public DepartmentDto postDepartment(@RequestBody DepartmentDto dto) {
        return ds.addData(dto);
    }

    @PatchMapping("/{id}")
    public DepartmentDto updateDepartment(@PathVariable Long id, @RequestBody Map<String, Object> updates) throws JsonMappingException {
        return ds.updateData(updates,id);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        return ds.deleteData(id);
    }
}
