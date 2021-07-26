package com.luthita.lesson05;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lesson05Ex01Controller {

	@RequestMapping("/lesson05/ex01")
	public String ex01() {
		return "lesson05/ex01";
	}
	
	@RequestMapping("/lesson05/ex02")
	public String ex02(Model model) {
		// list
		List<String> fruits = new ArrayList<>();
		fruits.add("apple");
		fruits.add("orange");
		fruits.add("mango");
		fruits.add("lemon");
		fruits.add("peach");
		
		model.addAttribute("fruits", fruits);
		
		
		// List<Map>
		List<Map<String, Object>> users = new ArrayList<>();
		Map<String, Object> map1 = new HashMap<>();
		map1.put("name", "함석윤");
		map1.put("age", 25);
		map1.put("hobby", "게임하기");
		users.add(map1);
		
		map1 = new HashMap<>();
		map1.put("name", "김철수");
		map1.put("age", 3);
		map1.put("hobby","영화보기");
		users.add(map1);
		
		model.addAttribute("users", users);
		return "lesson05/ex02";
	}
	
	@RequestMapping("/lesson05/ex03")
	public String ex03(Model model) {
		Date today = new Date();
		model.addAttribute("today",today);
		return "lesson05/ex03";
	}
}
