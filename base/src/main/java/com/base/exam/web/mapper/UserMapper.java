package com.base.exam.web.mapper;

import java.util.List;
import java.util.Map;

import com.base.exam.web.dto.AdminDTO;
import com.base.exam.web.dto.UserDTO;

public interface UserMapper {

	public void userInsert(UserDTO userDTO) throws Exception;
	
	public UserDTO login(Map<String,Object> userMap) throws Exception;
	
	public int idCheck(UserDTO userDTO) throws Exception;
	
	public List<UserDTO> userList(UserDTO userDTO) throws Exception;
	
	public List<UserDTO> userList2(AdminDTO adminDTO) throws Exception;
	
	public void userUpdate(UserDTO userDTO) throws Exception;
	
	public UserDTO userView(UserDTO userDTO) throws Exception;
	
	public void userDelInfo(UserDTO userDTO) throws Exception;
	
	public void myPage(UserDTO userDTO) throws Exception;
}
