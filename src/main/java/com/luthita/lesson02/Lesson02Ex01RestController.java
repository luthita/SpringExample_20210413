package com.luthita.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luthita.lesson02.bo.UsedGoodsBO;
import com.luthita.lesson02.model.UsedGoods;

@RestController	// Controller 는 화면 구성의 표현계층
public class Lesson02Ex01RestController {
	
	@Autowired
	private UsedGoodsBO usedGoodsBO;
	
	// Test
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> ex01(){
		List<UsedGoods> usedGoodsList = usedGoodsBO.getUsedGoodsList();
		return usedGoodsList;
	}
}
