package com.momo.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.momo.spring.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>, QuerydslPredicateExecutor<Student> {
	
}
