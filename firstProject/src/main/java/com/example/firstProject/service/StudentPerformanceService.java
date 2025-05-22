package com.example.firstProject.service;

import com.example.firstProject.entity.StudentPerformance;
import java.util.List;

public interface StudentPerformanceService {
    StudentPerformance createStudent(StudentPerformance student);

    List<StudentPerformance> getAllStudents();

    StudentPerformance getStudentById(Integer id);

    StudentPerformance updateStudent(Integer id, StudentPerformance updatedStudent);

    void deleteStudent(Integer id);
}
