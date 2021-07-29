package com.luthita.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luthita.lesson04.dao.NewUserDAO;
import com.luthita.lesson04.model.NewUser;

@Service
public class NewUserBO {
	
	@Autowired
	private NewUserDAO newUserDAO;
	
	// ctrl + alt + H => 메소드를 부르는 클래스를 찾는다.
	// alt + shift + R => 메소드 이름변경(프로젝트 내 모든 (호출되는)메소드 이름 변경)
	
	public void addNewUser(String name, String yyyymmdd, String email, String introduce) {
		newUserDAO.insertNewUser(name, yyyymmdd, email, introduce);
	}
	
	public NewUser getLastUser() {
		return newUserDAO.selectLastUser();
	}
}
