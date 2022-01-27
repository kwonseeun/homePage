package com.base.exam.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.exam.web.dto.BoardDTO;
import com.base.exam.web.dto.ReplyDTO;
import com.base.exam.web.mapper.ReplyMapper;
import com.base.exam.web.service.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyMapper replyMapper;

	@Override
	public List<ReplyDTO> commentList(ReplyDTO replyDTO) throws Exception {
		return replyMapper.commentList(replyDTO);
	}

	@Override
	public Map<String,Object> commentInsert(ReplyDTO replyDTO) throws Exception {
		Map<String,Object> resultMap = new HashMap<String, Object>();
		
		try {
			replyMapper.commentInsert(replyDTO);
			
			resultMap.put("resultCode", "0000");
			resultMap.put("resultMsg", "");
			
		} catch (Exception e) {
			resultMap.put("resultCode", "9999");
			resultMap.put("resultMsg", "실패하였습니다.");
			e.printStackTrace();		
		}
			return resultMap; 
	}
	@Override
	public Map<String,Object> commentDelete(ReplyDTO replyDTO) throws Exception {
		Map<String,Object> resultMap = new HashMap<String, Object>();
		
		try {
			replyMapper.commentDelete(replyDTO);
			
			resultMap.put("resultCode", "0000");
			resultMap.put("resultMsg", "");
			
		} catch (Exception e) {
			resultMap.put("resultCode", "9999");
			resultMap.put("resultMsg", "실패하였습니다.");
			e.printStackTrace();		
		}
	
		return resultMap;
	}

	@Override
	public Map<String,Object> commentUpdate(ReplyDTO replyDTO) throws Exception {	
		Map<String,Object> resultMap = new HashMap<String,Object>();

		try {
			replyMapper.commentUpdate(replyDTO);
			resultMap.put("resultCode", "0000");
			resultMap.put("resultMsg", "");
			
		} catch (Exception e) {
			resultMap.put("resultCode", "9999");
			resultMap.put("resultMsg", "실패하였습니다.");
			e.printStackTrace();
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> commentSelect(ReplyDTO replyDTO) throws Exception {
		Map<String,Object> resultMap = new HashMap<String,Object>();

		try {
			replyMapper.commentSelect(replyDTO);
			resultMap.put("resultCode", "0000");
			resultMap.put("resultMsg", "");
			
		} catch (Exception e) {
			resultMap.put("resultCode", "9999");
			resultMap.put("resultMsg", "실패하였습니다.");
			e.printStackTrace();
		}
		return resultMap;

	}
}
