package com.momo.spring.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.momo.spring.demo.model.QStudent;
import com.momo.spring.demo.model.Student;
import com.querydsl.core.types.dsl.BooleanExpression;

public class StudentCriteriaBuilder {

	private static Logger log = LoggerFactory.getLogger(StudentCriteriaBuilder.class);
	
	private static QStudent Qstudent = QStudent.student;

	private Student student;
	private List<BooleanExpression> predicates = new ArrayList<>();

	public StudentCriteriaBuilder(Student student) {
		this.student = student;
		log.info("StudentCriteriaBuilder - Student: " + student);
	}

	public BooleanExpression build() {
		if (!Objects.toString(student.getEngName(), "").isEmpty())
			predicates.add(Qstudent.engName.eq(student.getEngName()));

		if (!Objects.toString(student.getChiName(), "").isEmpty())
			predicates.add(Qstudent.chiName.eq(student.getChiName()));

		if (!Objects.toString(student.getSchLvl(), "").isEmpty())
			predicates.add(Qstudent.schLvl.eq(student.getSchLvl()));

		if (!Objects.toString(student.getSchScc(), "").isEmpty())
			predicates.add(Qstudent.schScc.eq(student.getSchScc()));

		if (!Objects.toString(student.getClassLvl(), "").isEmpty())
			predicates.add(Qstudent.classLvl.eq(student.getClassLvl()));

		if (!Objects.toString(student.getClassCode(), "").isEmpty())
			predicates.add(Qstudent.classCode.eq(student.getClassCode()));

		if (!Objects.toString(student.getRegNum(), "").isEmpty())
			predicates.add(Qstudent.regNum.eq(student.getRegNum()));

		if (!Objects.toString(student.getStrn(), "").isEmpty())
			predicates.add(Qstudent.strn.eq(student.getStrn()));
		
		if (predicates.size() != 0) {
			BooleanExpression predicate = predicates.get(0);
			for (int i = 1; i < predicates.size(); i++) {
				predicate = predicate.and(predicates.get(i));
			}
			
			return predicate;
		} else {
			return null;
		}

	}
}
