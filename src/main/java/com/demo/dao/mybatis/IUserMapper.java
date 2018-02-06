package com.demo.dao.mybatis;

import java.util.List;

import com.demo.entity.User;

public interface IUserMapper {

	public List<User> getAllUser() throws Exception;
}
