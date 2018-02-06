package com.demo.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.UserDao;
import com.demo.entity.User;

@Service("/userbiz")
public class UserBiz {

	@Autowired
	private UserDao userdao;

	public List<User> getAllUser() throws Exception {
		List<User> users = null;
		users = userdao.getAllUser();
		return users;
	}
}
