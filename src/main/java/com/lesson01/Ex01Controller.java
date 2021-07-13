package com.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/ex01")
@Controller	// Controller Spring Bean
public class Ex01Controller {
	
	// 요청 url : http://localhost:8080/lesson01/ex01/1
	@RequestMapping("/1")
	@ResponseBody	// 리턴되는 값을 HTML Response body 로 보낸다.
	public String printString() {
		String text = "예제 1번<br>문자열을 response body로 보내는 예제";
		return text;
	}
	
	// 요청 url : http://localost/lesson01/ex01/2
	@RequestMapping("/2")
	public @ResponseBody Map<String, Object> printMap(){
		Map<String, Object> map = new HashMap<>();
		map.put("apple", 4);
		map.put("banana", 10);
		map.put("orange", 111);
		map.put("lemon", 77);
		
		// map을 리턴하면 JSON으로 나타난다.
		// Web Starter에 jackson( Map -> JSON 변환) 이라는 라이브러리가 포함되어 있기 때문
		return map;		// Map : {"apple"=4 ....... }
						// JSON : {"apple":4 ..... }
	}
	
}
