package com.luthita.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luthita.lesson03.dao.ReviewDAO;
import com.luthita.lesson03.model.Review;

@Service
public class ReviewBO {

	@Autowired
	private ReviewDAO reviewDAO;
	
	public Review getReview(int id) {
		return reviewDAO.selectReview(id);
	}
	
	public int insertReview(Review review) {
		return reviewDAO.insertReview(review) ;
	}
	
	public int insertReviewAsField(String storeName, String menu, String userName, double point, String review) {
		return reviewDAO.insertReviewAsField(storeName, menu, userName, point, review);
	}
	
	public int updateReview(int id, String review) {
		return reviewDAO.updateReview(id, review);
	}
	
	public int deleteReviewById(int id) {
		return reviewDAO.deleteReviewById(id);
	}
}
