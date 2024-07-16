package com.week2.work.week2work.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.week2.work.week2work.DTO.DepartmentDto;
import com.week2.work.week2work.Service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService ds;

    @GetMapping
    public String getDepartment() {
        return "Department";
    }

    @PostMapping
    public DepartmentDto postDepartment(@RequestBody DepartmentDto dto) {
        return ds.addData(dto);
    }
}
