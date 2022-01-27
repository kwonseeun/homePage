package com.base.exam.web.mapper;

import java.util.List;

import com.base.exam.web.dto.CommentDTO;
import com.base.exam.web.dto.Search;
import com.base.exam.web.dto.TestDTO;

public interface TestMapper {

	public List<TestDTO> getBoardList(Search search) throws Exception;
	
	public void insertBoard(TestDTO testDTO) throws Exception;
	
	public TestDTO getBoardContent(int bid) throws Exception;
		
	public void updateBoard(TestDTO testDTO) throws Exception;
	
	public int updateViewCnt(int bid) throws Exception;
	
	public void deleteBoard(int bid) throws Exception;
	
	public int getBoardListCnt(Search search) throws Exception;
	
	// 댓글 로직 
	public List<CommentDTO> getReplyList(int bid) throws Exception;
	
	// 댓글 등록
	public int saveReply(CommentDTO commentDTO) throws Exception;
	
	// 댓글 수정
	public int updateReply(CommentDTO commentDTO) throws Exception;
	
	// 댓글 삭제
	public int deleteReply(int rid) throws Exception;
}
