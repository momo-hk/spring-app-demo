package com.momo.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.momo.spring.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
}
