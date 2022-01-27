package com.base.exam.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.core.web.paging.PageNavigator;
import com.base.core.web.paging.Result;
import com.base.exam.web.dto.UserDTO;
import com.base.exam.web.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/", method=RequestMethod.POST)
	public String main(UserDTO userDTO) throws Exception {
		
		return "user/login.pop";
	}
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mainGet(UserDTO userDTO) throws Exception {
		
		return "user/login.pop";
	}
	@RequestMapping(value="/joinForm", method=RequestMethod.POST)
	public String joinForm(UserDTO userDTO) throws Exception {
		System.out.println(">>>>>>>> joinForm 진입 ");
		return "user/joinForm.tiles";
	}
	
	@RequestMapping(value="/joinRegist", method=RequestMethod.POST)
	public String joinRegist(UserDTO userDTO,Model model) throws Exception {
		int result = userService.idCheck(userDTO);
		try {
			if (result == 1) {
				return "/joinForm"; // id 존재시 회원가입 페이지로 이동 
			}else if (result == 0) {
				userService.joinRegist(userDTO);
			}
		} catch (Exception e) {

		}		
		return "redirect:/";
	}
	
	// 로그인 
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpServletRequest req, UserDTO userDTO,Model model, HttpSession session) throws Exception {	
		Map<String,Object> userMap = new HashMap<String,Object>();	
		userMap.put("id", userDTO.getId());
		userMap.put("pw", userDTO.getPw());
			
		UserDTO result = userService.login(userMap);	

		if (result != null) {
			session.setAttribute("loginUserInfo", result);
			return "redirect:/main";
		}else{		
			model.addAttribute("message", "id와 비밀번호를 확인해주세요 ");
			return "user/login.pop";
		}		
	}
	
	// 메인 페이지 
	@RequestMapping(value="/main",method=RequestMethod.GET)
	public String main() throws Exception{
		
		return "main";
	}	
	
	//로그아웃  
	@RequestMapping(value="/logout",method=RequestMethod.POST)
	public String logout(HttpSession session) throws Exception{
		session.invalidate(); 
		
		return "redirect:/";
	}		
	// 아이디 체크 
	@ResponseBody
	@RequestMapping(value="/idCheckDup",method=RequestMethod.POST)
	public int idCheck (UserDTO userDTO) throws Exception{
		int result = userService.idCheck(userDTO);

		return result;
	}

	// 유저 상세정보 
	@RequestMapping(value="/userView", method=RequestMethod.POST)
	public String userView(UserDTO userDTO, Model model) throws Exception{
		model.addAttribute("user", userService.userView(userDTO));

		return "user/userView.tiles";
	}
	
	// 유저 정보수정 폼 
	@RequestMapping(value="/userUpdateFrm",method=RequestMethod.POST)
	public String userUpdateFrm(Model model, UserDTO userDTO) throws Exception {
		UserDTO user = userService.userView(userDTO);
		model.addAttribute("user", user);
		
		return "user/userUpdateFrm.tiles";
	}	
	
	// 유저 정보수정 
	@RequestMapping(value="/userUpdate",method=RequestMethod.POST)
	public String userUpdate(Model model,UserDTO userDTO) throws Exception {		
		userService.userUpdate(userDTO);
		
		return userList(model, userDTO);
	}	
	
	//유저 정보 삭제 
	@RequestMapping(value="/userDelInfo", method=RequestMethod.POST)
	public String userDelInfo(Model model, UserDTO userDTO) throws Exception{
		userService.userDelInfo(userDTO);

		return userList(model, userDTO);

	}
	
	// 관리자 로그인
	@RequestMapping(value = "/userList", method = RequestMethod.POST)
	public String userList(Model model, UserDTO userDTO) throws Exception {
		List<UserDTO> userList = userService.userList(userDTO);
		int totalCount = 0;
		if (userList.size() > 0 ) {
			totalCount = userList.get(0).getTotalCount();
		}
		model.addAttribute("result", new Result(userList, new PageNavigator(userDTO.getCurrentPage(), userDTO.getPageSize(),totalCount )));
		
		return "user/userList.tiles";
	}
	
	@RequestMapping(value="/myPageFrm", method=RequestMethod.POST)
	public String myPageFrm(Model model, UserDTO userDTO ,HttpSession session, HttpServletRequest req) throws Exception{
		UserDTO myPage = (UserDTO) session.getAttribute("loginUserInfo");
		UserDTO viewPage = userService.userView(myPage);

		model.addAttribute("user", viewPage);
		
		return "user/myPageFrm.tiles";
	}
	
	@RequestMapping(value= "/myPage", method = RequestMethod.POST)
	public String myPage(Model model, UserDTO userDTO) throws Exception{
		 userService.myPage(userDTO);

		return "main";
	}
	
	@RequestMapping(value= "/messageBox", method = RequestMethod.POST)
	public String messageBox(Model model, UserDTO userDTO) throws Exception{
		userService.myPage(userDTO);
		
		return "user/messageBox";
	}

}	