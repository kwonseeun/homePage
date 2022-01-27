package com.base.exam.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.exam.web.dto.BoardDTO;
import com.base.exam.web.mapper.BoardMapper;
import com.base.exam.web.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
	
	
	@Autowired
	private BoardMapper boardMapper;
	
	public List<BoardDTO> boardList(BoardDTO boardDTO) throws Exception  {
		return boardMapper.boardList(boardDTO);
	}

	@Override
	public void boardInsert(BoardDTO boardDTO) throws Exception {
		boardMapper.boardInsert(boardDTO);
		
	}
	@Override
	public void insert(BoardDTO boardDTO) throws Exception {
		boardMapper.boardInsert(boardDTO);
	
	}
	@Override
	public BoardDTO boardDetail(BoardDTO boardDTO) throws Exception {

		
	BoardDTO d = boardMapper.boardDetail(boardDTO);
		
		if (d == null) {
			d = new BoardDTO() ;
			d.setResultCode("9999");
			d.setResultMsg("아이디가 없습니다.");
		}else {
			boardMapper.boardViewCnt(boardDTO);
			d.setResultCode("0000");
			d.setResultMsg("성공하였습니다.");
		}
			
		return d;
	}
	
	@Override
	public void boardUpdate(BoardDTO boardDTO) throws Exception {
		boardMapper.boardUpdate(boardDTO);
		
	}

	@Override
	public void boardDelete(BoardDTO boardDTO) throws Exception {
		boardMapper.boardDelete(boardDTO);
	}

	@Override
	public int boardViewCnt(BoardDTO boardDTO) throws Exception {
		return boardMapper.boardViewCnt(boardDTO);
	}

	@Override
	public void updateReplyCount(BoardDTO boardDTO) throws Exception {
		boardMapper.updateReplyCount(boardDTO);
		
	}

}
