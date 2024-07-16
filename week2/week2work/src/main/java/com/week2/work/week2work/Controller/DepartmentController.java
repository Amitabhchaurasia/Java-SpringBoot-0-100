package com.week2.work.week2work.Controller;

import org.springframework.web.bind.annotation.*;
import com.week2.work.week2work.DepartmentEntity.DepartmentEntity;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    
    @GetMapping
    public String getDepartment(){
        return "Department";
    }

    @PostMapping
    public DepartmentEntity postDepartment(@RequestBody DepartmentEntity departmentEntity){
        // Add logic to save the departmentEntity to database or process it
        return departmentEntity;
    }
}
