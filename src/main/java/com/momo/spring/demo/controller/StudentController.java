package com.momo.spring.demo.controller;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.momo.spring.demo.model.Pager;
import com.momo.spring.demo.model.Student;
import com.momo.spring.demo.repository.StudentCriteriaBuilder;
import com.momo.spring.demo.repository.StudentRepository;
import com.momo.spring.demo.service.ConfigurationService;
import com.querydsl.core.types.dsl.BooleanExpression;

@Controller
@SessionAttributes("student")
@RequestMapping(value = "/students")
public class StudentController {

	private static Logger log = LoggerFactory.getLogger(StudentController.class);
	
	private static int DEFAULT_PAGE;
	private static int DEFAULT_PAGE_SIZE;
	private static int BUTTONS_TO_SHOW;
	private static int[] PAGE_SIZES;
	
	private ConfigurationService config;
	
	private StudentRepository studentRepo;
	
	public StudentController(StudentRepository studentRepository, ConfigurationService configService) {
		studentRepo = studentRepository;
		config = configService;
	}
	
	@PostConstruct
	public void init() {
		DEFAULT_PAGE = config.getDefaultPageNumber();
		DEFAULT_PAGE_SIZE = config.getDefaultPageSize();
		BUTTONS_TO_SHOW = config.getButtonToShow();
		PAGE_SIZES = config.getPageSizeOptions();
	}
	
	@ModelAttribute("student")
	public Student getStudent() {
		return new Student();
	}
	
	@GetMapping("/pagination")
	public String getStudentsByPage(@RequestParam(value="size") Optional<Integer> size, @RequestParam(value="page") Optional<Integer> page, @ModelAttribute("student") Student student, ModelMap model) {

		log.info("GET - student: " + student);
		
		int evalPage = (page.orElse(0) < 1)? DEFAULT_PAGE: page.get() - 1;
		int evalSize = size.orElse(DEFAULT_PAGE_SIZE);
		
		Page<Student> students;
		BooleanExpression predicate = new StudentCriteriaBuilder(student).build();
		if (predicate != null) {
			students = studentRepo.findAll(predicate, PageRequest.of(evalPage, evalSize));
		} else {
			students = studentRepo.findAll(PageRequest.of(evalPage, evalSize));
		}
		
		Pager pager = new Pager(students.getTotalPages(), students.getNumber(), BUTTONS_TO_SHOW);
		
		model.addAttribute("student", student);
		model.addAttribute("students", students);
		model.addAttribute("selectedPageSize", evalSize);
		model.addAttribute("pageSizes", PAGE_SIZES);
		model.addAttribute("pager", pager);
		
		return "students";
	}
	
	@PostMapping("/pagination")
	public ModelAndView getStudentsByCriteria(@ModelAttribute("student") Student student, RedirectAttributes redirect) {
		
		if (student != null) {
			redirect.addFlashAttribute("student", student);
		}
	
		return new ModelAndView("redirect:/students/pagination");
	}
}
