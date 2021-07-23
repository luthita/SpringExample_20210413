package com.luthita.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luthita.lesson04.bo.NewStudentBO;
import com.luthita.lesson04.model.NewStudent;

@RequestMapping("/lesson04")
@Controller
public class NewStudentController {
	// 요청 URL : http://localhost:8080/lesson04/ex02/1
	
	@Autowired
	private NewStudentBO newStudentBO;
	
	@GetMapping("/ex02/1")
	public String addStudentView() {
		return "lesson04/addStudent";
	}
	
	@PostMapping("/ex02/add_student")
	public String addStudent(
			@ModelAttribute NewStudent newStudent,
			Model model
			) {
		// insert DB
		newStudentBO.addNewStudent(newStudent); // name 태그 값이 들어간다.
		
		// select DB
		newStudent = newStudentBO.getNewStudentById(newStudent.getId());
		model.addAttribute("result",newStudent);
		model.addAttribute("subject", "학생 정보");
		return "lesson04/afterAddStudent";
	}
}
