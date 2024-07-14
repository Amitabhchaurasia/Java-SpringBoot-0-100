package com.springwebtutorial.springwebtutorila.controller;

import org.springframework.web.bind.annotation.RestController;

import com.springwebtutorial.springwebtutorila.dto.EmployeeDTO;
import com.springwebtutorial.springwebtutorila.entity.EmployeeEntity;
import com.springwebtutorial.springwebtutorila.repository.EmployeeRepository;
import com.springwebtutorial.springwebtutorila.service.EmployeeService;

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

// private final EmployeeRepository employeeRepository;
// EmployeeController(EmployeeRepository employeeRepository){
//     this.employeeRepository = employeeRepository;
// }

private final EmployeeService employeeService;
EmployeeController(EmployeeService employeeService){
    this.employeeService = employeeService;
}

@GetMapping("/{id}")
public EmployeeDTO getEmpById(@PathVariable long id){
    return employeeService.getEmpById(id);
}

@GetMapping
public List<EmployeeDTO> getAllEmp(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy){
    return employeeService.getAllEmp(age, sortBy);
}

@PostMapping
public EmployeeDTO addEmp(@RequestBody EmployeeDTO EmployeeDTO){
    return employeeService.addEmp(EmployeeDTO);

}
    
}
