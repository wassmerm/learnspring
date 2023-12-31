package com.wassmer.learnspring.controller;


import com.wassmer.learnspring.model.Employee;
import com.wassmer.learnspring.repository.EmployeeDbRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    private final EmployeeDbRepository employeeRepository;

    @Autowired
    public EmployeeRestController(EmployeeDbRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    };

    @GetMapping("")
    public List<Employee> findAll() { return employeeRepository.findAll();}

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Employee employee) {
      employeeRepository.save(employee);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Employee employee, @PathVariable Integer id) {
        if(!employeeRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
        employeeRepository.save(employee);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        employeeRepository.deleteById(id);
    }

    @GetMapping("/filter/{keyword}")
    public List<Employee> findByNameContains(@PathVariable String keyword) {
        return employeeRepository.findAllByNameContainsIgnoreCase(keyword);
    }
}
