package com.base.exam.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.exam.web.dto.ReplyDTO;
import com.base.exam.web.dto.UserDTO;
import com.base.exam.web.service.ReplyService;

@Controller
public class ReplyController {
	
	
	@Autowired
	private ReplyService replyService;

	// 댓글 목록
	@RequestMapping("/commentList")
	@ResponseBody
	public List<ReplyDTO> commentList(@RequestParam int bid, ReplyDTO replyDTO) throws Exception{	

		System.out.println(">>>>>>>>ReplyCOntroller 의 값 , , , " + replyDTO);
		 List<ReplyDTO> result = replyService.commentList(replyDTO);
		 
		return result;		

	}
	
	// 댓글 등록 
	@RequestMapping("/commentInsert")
	@ResponseBody
	public Map<String,Object>  commentInsert(ReplyDTO replyDTO, HttpSession session) throws Exception{
		
		UserDTO result = (UserDTO) session.getAttribute("loginUserInfo");
		String writer = result.getId();
		replyDTO.setRegId(writer);
		
		
		return replyService.commentInsert(replyDTO);
	}
	
	// 댓글 삭제 
	@RequestMapping("/commentDelete")
	@ResponseBody
	public Map<String,Object> commentDelete(ReplyDTO replyDTO) throws Exception{

		return replyService.commentDelete(replyDTO);
	}
	
	// 댓글 수정 
	@RequestMapping("/commentUpdate")
	@ResponseBody
	public Map<String,Object> commentUpdate(ReplyDTO replyDTO) throws Exception{
		
		return replyService.commentUpdate(replyDTO);	
	}
	
	// 댓글 조회 
	@RequestMapping("/commentSelect")
	@ResponseBody
	public Map<String,Object> commentSelect(ReplyDTO replyDTO) throws Exception{
		
		return replyService.commentSelect(replyDTO);
	}
}
