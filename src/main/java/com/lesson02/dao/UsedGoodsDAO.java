package com.lesson02.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lesson02.model.UsedGoods;

@Repository
public interface UsedGoodsDAO {
	// DAO(Mapper)는 DB와 가장 밀접한 관계를 가지고 있음
	public List<UsedGoods> selectUsedGoodsList();
}
