package com.springwebtutorial.springwebtutorila.controller;

import org.springframework.web.bind.annotation.RestController;

import com.springwebtutorial.springwebtutorila.dto.EmployeeDTO;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/employees")
public class EmployeeController {
    
//    @GetMapping(path = "/getmsg")
//    public String getmsg(){
//     return "This is from msg";
//    }

@GetMapping("/{id}")
public EmployeeDTO getEmpById(@PathVariable long id){
    return new EmployeeDTO(id,"Ankur","ankur@gmail.com",27,LocalDate.of(2024,8, 13),true);
}

@GetMapping
public String getAllEmp(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy){
    return "Hi age "+age+" "+sortBy;
}
    
}
