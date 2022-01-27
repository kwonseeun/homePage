package com.base.exam.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.exam.web.dto.AdminDTO;
import com.base.exam.web.dto.UserDTO;
import com.base.exam.web.mapper.AdminMapper;
import com.base.exam.web.mapper.UserMapper;
import com.base.exam.web.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminMapper adminMapper;

	@Autowired
	UserMapper userMapper;
	
	@Override
	public void adminInfo() throws Exception {		
		
	}

	// 관리자 로그인 
	@Override
	public AdminDTO adminLogin(Map<String,Object> adminMap) throws Exception {
	
		System.out.println(">>>>>>>>>>>>>>>>>>>> adminServiceimpl"+ adminMap);
		return adminMapper.adminLogin(adminMap);
	}
	
	// 유저 리스트 
	@Override
	public List<UserDTO> userList(AdminDTO adminDTO) throws Exception {
		return userMapper.userList2(adminDTO);
	}

	// 로그인 체크 
	@Override
	public AdminDTO loginCk(AdminDTO adminDTO) throws Exception {	
		return adminMapper.loginCk(adminDTO);
	}
}
