package com.luthita.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // jsp는  @ResponseBody 사용하면 안된다.
// View(jsp)는 controller를 사용해야한다
public class Ex02Controller {

	// url : http://localhost:8080/lesson01/ex02/1
	@RequestMapping("/lesson01/ex02/1")
	public String ex02_1() {
		
		return "lesson01/ex02";		// jsp �̸�
	}
	
	@RequestMapping("/lesson01/quiz03/1")
	public String quiz03_1() {
		return "lesson01/quiz03";
	}
	
}
