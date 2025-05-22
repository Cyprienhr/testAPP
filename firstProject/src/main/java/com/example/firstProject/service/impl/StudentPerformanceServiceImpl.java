package com.example.firstProject.service.impl;

import com.example.firstProject.entity.StudentPerformance;
import com.example.firstProject.repository.StudentPerformanceRepository;
import com.example.firstProject.service.StudentPerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentPerformanceServiceImpl implements StudentPerformanceService {

    @Autowired
    private StudentPerformanceRepository repository;

    @Override
    public StudentPerformance createStudent(StudentPerformance student) {
        return repository.save(student);
    }

    @Override
    public List<StudentPerformance> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public StudentPerformance getStudentById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public StudentPerformance updateStudent(Integer id, StudentPerformance updatedStudent) {
        Optional<StudentPerformance> existing = repository.findById(id);
        if (existing.isPresent()) {
            StudentPerformance student = existing.get();
            student.setName(updatedStudent.getName());
            student.setDepartment(updatedStudent.getDepartment());
            student.setModule(updatedStudent.getModule());
            student.setMarks(updatedStudent.getMarks());
            student.setLecturer(updatedStudent.getLecturer());
            return repository.save(student);
        }
        return null;
    }

    @Override
    public void deleteStudent(Integer id) {
        repository.deleteById(id);
    }
}
