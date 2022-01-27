package com.base.exam.web.service;

import java.util.List;

import com.base.exam.web.dto.BoardDTO;

public interface BoardService {

	// 게시글 목록 
	public List<BoardDTO> boardList(BoardDTO boardDTO) throws Exception ;

	// 게시글 등록 
	public void boardInsert(BoardDTO boardDTO) throws Exception ; 
	
	// 게시글 등록 
	public void insert(BoardDTO boardDTO) throws Exception ; 
	
	// 게시글 조회 
	public BoardDTO boardDetail(BoardDTO boardDTO) throws Exception;

	// 게시글 수정 
	public void boardUpdate(BoardDTO boardDTO) throws Exception;
	
	// 게시글 삭제 
	public void boardDelete(BoardDTO boardDTO) throws Exception;
	
	// 조회수 증가 
	public int boardViewCnt(BoardDTO boardDTO) throws Exception;

	// 댓글 수 
	public void updateReplyCount(BoardDTO boardDTO) throws Exception;
}
