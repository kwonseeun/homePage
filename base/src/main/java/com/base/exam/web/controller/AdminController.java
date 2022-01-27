package com.base.exam.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.base.exam.web.dto.AdminDTO;
import com.base.exam.web.dto.UserDTO;
import com.base.exam.web.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	// 관리자 로그인페이지
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin() throws Exception {

		return "admin/login.pop";
	}

	// 관리자 로그인 체크
	@RequestMapping(value = "/adminLoginAction", method = RequestMethod.POST)
	public String adminLoginAction(Model model, AdminDTO adminDTO,HttpServletRequest req) throws Exception {
		AdminDTO adminInfo = adminService.loginCk(adminDTO);
		
		if (adminInfo == null) {
			model.addAttribute("message", "잘못된 로그인 정보입니다.");
			model.addAttribute("adminDTO", adminDTO);
			
			return "admin/login";
		}else {
			HttpSession session = req.getSession(false);
			session.setAttribute("adminInfo", adminInfo);
		}
		return "redirect:/main";
	}	

	// 관리자 홈 
	@RequestMapping(value = "/adminInfo", method = RequestMethod.POST)
	public String adminInfo() throws Exception {

		return "admin/adminInfo.pop";
	}

	//관리자 로그인 
	@RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
	public String adminLogin(Model model, AdminDTO adminDTO, HttpSession session, HttpServletRequest req)
			throws Exception {
		Map<String, Object> adminMap = new HashMap<String, Object>();
		adminMap.put("id", adminDTO.getId());
		adminMap.put("pw", adminDTO.getPw());

		AdminDTO result = adminService.adminLogin(adminMap);

		if (result != null) {
			session.setAttribute("adminInfo", result);
			return "admin/adminInfo.tiles";
		} else {
			model.addAttribute("adminLogin", result);
			return "main.tiles";
		}
	}

}
