package com.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01")
@RestController 	// @Controller + @Responsebody : 데이터를 내릴 때, 주로 사용
public class Ex01RestController {

	// 요청 url : http://localhost:8080/lesson01/ex01/3
	@RequestMapping("/3")
	public String printString() {
		return "@RestController를 사용해서 String을 리턴해본다.";
	}
	
	@RequestMapping("/4")
	public Map<String, String> printMap(){
		Map<String, String> map = new HashMap<>();
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		
		return map; // jackson 으로 인해 json으로 변환
	}
	
	@RequestMapping("/5")
	public Data printData() {
		Data data = new Data();	// 일반 Java Bean
		data.setId(1);
		data.setName("함석윤");
		return data;	// 일반 Bean 객체도 jaskson으로 인해 json으로 변환
	}
	
	@RequestMapping("/6")
	public ResponseEntity<Data> entity() {
		Data data = new Data(); // 일반 Java Bean
		data.setId(2);
		data.setName("햄찌");
		
		// 크롬 > Network 탭 응답값 확인
		// return new ResponseEntity<>(data, HttpStatus.OK);	// 200 OK
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
