package com.example.firstProject.controller;

import com.example.firstProject.entity.StudentPerformance;
import com.example.firstProject.service.StudentPerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentPerformanceController {

    @Autowired
    private StudentPerformanceService service;

    @PostMapping
    public StudentPerformance createStudent(@RequestBody StudentPerformance student) {
        return service.createStudent(student);
    }

    @GetMapping
    public List<StudentPerformance> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentPerformance getStudentById(@PathVariable Integer id) {
        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public StudentPerformance updateStudent(@PathVariable Integer id, @RequestBody StudentPerformance updatedStudent) {
        return service.updateStudent(id, updatedStudent);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        service.deleteStudent(id);
    }
}
