package com.example.firstProject.repository;

import com.example.firstProject.entity.StudentPerformance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentPerformanceRepository extends JpaRepository<StudentPerformance, Integer> {
}
