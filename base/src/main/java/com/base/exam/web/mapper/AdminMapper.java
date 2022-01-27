package com.base.exam.web.mapper;

import java.util.Map;

import com.base.exam.web.dto.AdminDTO;
import com.base.exam.web.dto.UserDTO;

public interface AdminMapper {
	
	public void adminInfo() throws Exception; 
	
	public AdminDTO adminLogin(Map<String,Object> adminMap) throws Exception;
	
	public AdminDTO loginCk(AdminDTO adminDTO) throws Exception;
	
	

}
