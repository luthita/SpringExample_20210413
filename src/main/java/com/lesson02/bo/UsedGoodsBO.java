package com.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lesson02.dao.UsedGoodsDAO;
import com.lesson02.model.UsedGoods;

@Service		// 비즈니스 로직이 담기는 용도의 스프링빈으로 등록
public class UsedGoodsBO {
	// DB의 테이블과 1대1 연동
	// 그래서 BO 클래스의 이름은 테이블명으로 만든다.
	@Autowired
	private UsedGoodsDAO usedGoodsDAO;
	
	public List<UsedGoods> getUsedGoodsList(){
		return usedGoodsDAO.selectUsedGoodsList();
	}
}
