package com.base.exam.web.mapper;

import java.util.List;
import java.util.Map;

import com.base.exam.web.dto.ReplyDTO;

public interface ReplyMapper {

	// 댓글 목록
	public List<ReplyDTO> commentList(ReplyDTO replyDTO) throws Exception;
		
	// 댓글 작성
	public void commentInsert(ReplyDTO replyDTO) throws Exception;

	// 댓글 삭제
	public void commentDelete(ReplyDTO replyDTO) throws Exception;
 
	// 댓글 수정 
	public void commentUpdate(ReplyDTO replyDTO) throws Exception;
	
	// 댓글 조회
	public ReplyDTO commentSelect(ReplyDTO replyDTO) throws Exception; 

}