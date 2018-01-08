package com.momo.spring.demo.controller;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.momo.spring.demo.model.Pager;
import com.momo.spring.demo.model.Student;
import com.momo.spring.demo.repository.StudentRepository;
import com.momo.spring.demo.service.ConfigurationService;

@Controller
@RequestMapping(value = "/students")
public class StudentController {

	private static final int[] PAGE_SIZES = { 5, 10, 20 };
	
	private ConfigurationService config;
	
	private StudentRepository studentRepo;
	
	public StudentController(StudentRepository studentRepository, ConfigurationService configurationService) {
		studentRepo = studentRepository;
		config = configurationService;
	}
		
	@GetMapping(value = "/Pagination")
	public String getStudentsByPage(@RequestParam(value="size") Optional<Integer> size, @RequestParam(value="page") Optional<Integer> page, Model model) {
		
		int pageNum = page.orElse(config.getDefaultPageNum());
		int pageSize = size.orElse(config.getDefaultPageSize());
		
		Page<Student> studentPage =  studentRepo.findAll(PageRequest.of(pageNum, pageSize));
		
		/*return studentPage
				.getContent()
				.stream()
				.sorted(Comparator.comparing(std -> std.getEngName()))
				.collect(Collectors.toList());*/
		
		int buttonToShow = config.getDefaultButtonToShow();
		Pager pager = new Pager(studentPage.getTotalPages(), studentPage.getNumber(), buttonToShow);

		model.addAttribute("persons", studentPage);
		model.addAttribute("pageSizes", PAGE_SIZES);
		model.addAttribute("pager", pager);
		
		return "students";
		
	}
}
