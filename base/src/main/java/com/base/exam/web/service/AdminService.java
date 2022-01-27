package com.base.exam.web.service;

import java.util.List;
import java.util.Map;

import com.base.exam.web.dto.AdminDTO;
import com.base.exam.web.dto.UserDTO;

public interface AdminService {
	
	public void adminInfo() throws Exception;
	
	public AdminDTO adminLogin(Map<String, Object> adminMap) throws Exception;

	public List<UserDTO> userList(AdminDTO adminDTO) throws Exception;
	
	public AdminDTO loginCk(AdminDTO adminDTO) throws Exception;
}
