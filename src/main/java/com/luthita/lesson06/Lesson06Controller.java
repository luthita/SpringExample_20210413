package com.luthita.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luthita.lesson04.bo.NewUserBO;

@RequestMapping("/lesson06/ex01")
@Controller
public class Lesson06Controller {
	@Autowired
	private NewUserBO newUserBO;
	
	/**
	 * 사용자 추가 화면
	 * @return
	 */
	
	@RequestMapping("/add_new_user_view")
	public String ex01() {
		return "lesson06/addNewUser";
	}
	
	@PostMapping("/add_new_user")
	@ResponseBody
	// ResponseBody 는 plain 타입으로 string이 찍힌다.
	// ResponseBody가 없다면 jsp 파일명을 따라 들어간다.
	public String addNewUser(
				@RequestParam("name") String name,
				@RequestParam("yyyymmdd") String yyyymmdd,
				// required = false -> null 허용
				@RequestParam(value ="email", required = false) String email,
				@RequestParam(value ="introduce", required = false) String introduce
			) {
		//DB insert
		newUserBO.addNewUser(name, yyyymmdd, email, introduce);
		
		
		return "success";
	}
}
