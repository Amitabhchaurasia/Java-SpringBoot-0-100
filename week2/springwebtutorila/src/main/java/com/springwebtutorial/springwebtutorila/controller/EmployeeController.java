package com.springwebtutorial.springwebtutorila.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.springwebtutorial.springwebtutorila.dto.EmployeeDTO;
import com.springwebtutorial.springwebtutorila.entity.EmployeeEntity;
import com.springwebtutorial.springwebtutorila.repository.EmployeeRepository;
import com.springwebtutorial.springwebtutorila.service.EmployeeService;

import java.time.LocalDate;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    // @GetMapping(path = "/getmsg")
    // public String getmsg(){
    // return "This is from msg";
    // }

    // private final EmployeeRepository employeeRepository;
    // EmployeeController(EmployeeRepository employeeRepository){
    // this.employeeRepository = employeeRepository;
    // }

    private final EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmpById(@PathVariable long id) {
        return employeeService.getEmpById(id);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmp(@RequestParam(required = false) Integer age,
            @RequestParam(required = false) String sortBy) {
        return employeeService.getAllEmp(age, sortBy);
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmp(@RequestBody EmployeeDTO EmployeeDTO) {
         EmployeeDTO emD= employeeService.addEmp(EmployeeDTO);
         if (emD == null) {
             return ResponseEntity.badRequest().build();
            
         }
         return ResponseEntity.ok(emD);

    }

    @PutMapping("/{id}")
    public EmployeeDTO updateEmp(@PathVariable long id, @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmp(id, employeeDTO);
    }

    @DeleteMapping("/{id}")
    public boolean deleteEmp(@PathVariable long id) {
        return employeeService.deleteEmp(id);
    }
    @PatchMapping("/{id}")
    public EmployeeDTO updateUser(@PathVariable Long id, @RequestBody Map<String, Object> updates) throws JsonMappingException {
       
            return employeeService.patchEmp(id, updates);
        
    }

    
}
