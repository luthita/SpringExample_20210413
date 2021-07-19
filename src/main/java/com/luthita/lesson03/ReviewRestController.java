package com.luthita.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luthita.lesson03.bo.ReviewBO;
import com.luthita.lesson03.model.Review;

@RestController
public class ReviewRestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	// 요청 URL : http://localhost/lesson03/ex01
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			// @RequestParam(value="id") int id	// 필수 파라미터 일때는, int 여도 됨.
												// 필수가 아닐 경우, 값 없어서 null이 아닌 0이 들어갈 수도
			// @RequestParam(value="id", required=true) int id		// 필수 파라미터
			// @RequestParam(value="id", required=false) Integer id // 비필수 파라미터(Integer로 선언)
			@RequestParam(value="id", defaultValue="1") int id // 비필수 파라미터, 디폴트값 1
	) {
		System.out.println("### id : " + id);
		return reviewBO.getReview(id);
	}
	
	// 요청 URL : http://localhost:8080/lesson03/ex02
	@RequestMapping("lesson03/ex02/1")
	public String ex02() {
		Review review = new Review();
		review.setStoreName("하남돼지집");
		review.setMenu("삼겹&명이나물혼밥세트");
		review.setUserName("함석윤");
		review.setPoint(4.5);
		review.setReview("혼자 먹기 딱 적당하네요!!");
		
		int row = reviewBO.insertReview(review) ; // insert 된 row 수를 리턴 받는다.
		
		return "success row count : " + row; // @ResponseBody 로 인해 String 값 자체가 responseBody에 담긴다.
		
	}
	
	@RequestMapping("lesson03/ex02/2")
	public String ex02_2() {
		int row = reviewBO.insertReviewAsField("도미노피자", "콤비네이션R", "함석윤", 5.0, "맛있네요!");
		return "success row count : " + row;
	}
}
