package com.base.exam.web.mapper;

import java.util.List;

import com.base.exam.web.dto.BoardDTO;

public interface BoardMapper {

	public List<BoardDTO> boardList(BoardDTO boardDTO) throws Exception;
	
	public void boardInsert(BoardDTO boardDTO) throws Exception;
	
	public void insert(BoardDTO boardDTO) throws Exception;
	
	public BoardDTO boardDetail(BoardDTO boardDTO) throws Exception;

	public void boardUpdate(BoardDTO boardDTO) throws Exception;
	
	public void boardDelete(BoardDTO boardDTO) throws Exception;
	
	public int boardViewCnt(BoardDTO boardDTO) throws Exception;
	
	public void updateReplyCount(BoardDTO boardDTO) throws Exception;

}
