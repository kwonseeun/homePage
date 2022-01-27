package com.base.exam.web.service;

import java.util.List;
import java.util.Map;

import com.base.exam.web.dto.ReplyDTO;

public interface ReplyService {
	
	public List<ReplyDTO> commentList(ReplyDTO replyDTO) throws Exception;
	
	public Map<String,Object> commentInsert(ReplyDTO replyDTO) throws Exception;

	public Map<String,Object>  commentDelete(ReplyDTO replyDTO) throws Exception;	
	
	public Map<String,Object> commentUpdate (ReplyDTO replyDTO) throws Exception;
	
	public Map<String,Object> commentSelect (ReplyDTO replyDTO) throws Exception;

}
