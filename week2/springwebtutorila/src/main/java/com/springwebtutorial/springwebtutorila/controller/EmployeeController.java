package com.springwebtutorial.springwebtutorila.controller;

import org.springframework.web.bind.annotation.RestController;

import com.springwebtutorial.springwebtutorila.dto.EmployeeDTO;
import com.springwebtutorial.springwebtutorila.entity.EmployeeEntity;
import com.springwebtutorial.springwebtutorila.repository.EmployeeRepository;

import java.time.LocalDate;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    
//    @GetMapping(path = "/getmsg")
//    public String getmsg(){
//     return "This is from msg";
//    }

private final EmployeeRepository employeeRepository;
EmployeeController(EmployeeRepository employeeRepository){
    this.employeeRepository = employeeRepository;
}

@GetMapping("/{id}")
public EmployeeEntity getEmpById(@PathVariable long id){
    return employeeRepository.findById(id).orElse(null);
}

@GetMapping
public List<EmployeeEntity> getAllEmp(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy){
    return employeeRepository.findAll();
}

@PostMapping
public EmployeeEntity addEmp(@RequestBody EmployeeEntity employeeEntity){
    return employeeRepository.save(employeeEntity);

}
    
}
