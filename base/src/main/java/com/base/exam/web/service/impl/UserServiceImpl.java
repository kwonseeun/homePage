package com.base.exam.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.exam.web.dto.UserDTO;
import com.base.exam.web.mapper.UserMapper;
import com.base.exam.web.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public void joinRegist(UserDTO userDTO) throws Exception {
		userMapper.userInsert(userDTO);
	}

	@Override
	public UserDTO login(Map<String, Object> userMap) throws Exception {
		return userMapper.login(userMap);
	}

	@Override
	public int idCheck(UserDTO userDTO) throws Exception {
		return userMapper.idCheck(userDTO);
	}	
	
	@Override
	public List<UserDTO> userList(UserDTO userDTO) throws Exception{
		return userMapper.userList(userDTO);
	}

	@Override
	public void userUpdate(UserDTO userDTO) throws Exception {
		userMapper.userUpdate(userDTO);
		
	}
	
	@Override
	public UserDTO userView(UserDTO userDTO) throws Exception {
		return userMapper.userView(userDTO);
	}

	@Override
	public void userDelInfo(UserDTO userDTO) throws Exception {
		userMapper.userDelInfo(userDTO);
	}

	@Override
	public void myPage(UserDTO userDTO) throws Exception {
		userMapper.myPage(userDTO);
		
	}	
}
