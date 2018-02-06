package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.demo.dao.mybatis.IUserMapper;
import com.demo.entity.User;

@Repository("/userdao")
public class UserDao {
	
	@Autowired
	private IUserMapper userMapper;
	
	public List<User> getAllUser() throws Exception{
		List<User> users = null;
		users = userMapper.getAllUser();
		return users;
	}

}
