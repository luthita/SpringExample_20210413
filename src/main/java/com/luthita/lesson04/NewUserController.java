package com.luthita.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.luthita.lesson04.bo.NewUserBO;
import com.luthita.lesson04.model.NewUser;

@Controller
public class NewUserController {
	
	@Autowired
	private NewUserBO newUserBO;
		// http://localhost:8080/lesson04/ex01/1
	@RequestMapping(path = "/lesson04/ex01/1", method = RequestMethod.GET)
	public String addUserView() {
		return "lesson04/addUser"; // view 경로
	}
	
	@RequestMapping("/lesson04/ex01/add_user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value = "email", required=false) String email, // 비필수 파라미터( null 가능)
			@RequestParam(value ="introduce", required=false) String introduce // 비필수 파라미터( null 가능)
	) {
		// request -> response
		
		// TODO db insert
		newUserBO.addNewUser(name, yyyymmdd, email, introduce);
		
		// 결과 jsp
		return "lesson04/afterAddUser";
	}
	/**
	 *  가장 최근에 추가된 사람 한명 가져오기
	 * @return
	 */
	// http://localhost:8080/lesson04/ex01/get_last_user
	@GetMapping("/lesson04/ex01/get_last_user")
	public String getLastUserView(Model model) { 	// view화면에 데이터를 넘겨주는 객체(ModelAndVIew 객체는 요즘 잘 사용하지 않는다)
		NewUser newUser = newUserBO.getLastUser();
		model.addAttribute("result",newUser);
		model.addAttribute("subject","회원 정보");
		return "lesson04/getLastUser";
	}
}
