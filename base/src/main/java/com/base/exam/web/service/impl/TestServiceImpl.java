package com.base.exam.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.exam.web.dto.CommentDTO;
import com.base.exam.web.dto.Pagenation;
import com.base.exam.web.dto.Search;
import com.base.exam.web.dto.TestDTO;
import com.base.exam.web.mapper.TestMapper;
import com.base.exam.web.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	TestMapper testMapper;
	
	@Override
	public List<TestDTO> getBoardList(Search search) throws Exception {
		return testMapper.getBoardList(search);
	}

	@Override
	public void insertBoard(TestDTO testDTO) throws Exception {
		testMapper.insertBoard(testDTO);
	}

	@Override
	public TestDTO getBoardContent(int bid) throws Exception {
		TestDTO testDTO = new TestDTO();
		
		testMapper.updateViewCnt(bid);
		testDTO =  testMapper.getBoardContent(bid);

		return testDTO;
	}

	@Override
	public void updateBoard(TestDTO testDTO) throws Exception {
		testMapper.updateBoard(testDTO);
	}

	@Override
	public int updateViewCnt(int bid) throws Exception {
		return testMapper.updateViewCnt(bid);
	}

	@Override
	public void deleteBoard(int bid) throws Exception {
		testMapper.deleteBoard(bid);		
	}

	@Override
	public int getBoardListCnt(Search search) throws Exception {
		return testMapper.getBoardListCnt(search);
	}

	@Override
	public List<CommentDTO> getReplyList(int bid) throws Exception {
		return testMapper.getReplyList(bid);
	}

	@Override
	public int saveReply(CommentDTO commentDTO) throws Exception {
		return testMapper.saveReply(commentDTO);
	}

	@Override
	public int updateReply(CommentDTO commentDTO) throws Exception {
		return testMapper.updateReply(commentDTO);
	}

	@Override
	public int deleteReply(int rid) throws Exception {
		return testMapper.deleteReply(rid);
	}
	
	
}
