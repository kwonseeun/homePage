package com.base.exam.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.base.core.web.paging.PageNavigator;
import com.base.core.web.paging.Result;
import com.base.exam.web.dto.BoardDTO;
import com.base.exam.web.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() throws Exception {
		
		return "test.tiles";
	}

	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public String boardListGET(Model model, BoardDTO boardDTO) throws Exception {

		return this.boardList(model, boardDTO);
	}

	@RequestMapping(value = "/boardList", method = RequestMethod.POST)
	public String boardListPost(Model model, BoardDTO boardDTO) throws Exception {

		return this.boardList(model, boardDTO);
	}

	// 게시글 목록
	public String boardList(Model model, BoardDTO boardDTO) throws Exception {

		List<BoardDTO> list = boardService.boardList(boardDTO);

		int totalCount = 0;
		if (list.size() > 0) {
			totalCount = list.get(0).getTotalCount();
		}

		model.addAttribute("result",
				new Result(list, new PageNavigator(boardDTO.getCurrentPage(), boardDTO.getPageSize(), totalCount)));

		return "boardList.tiles";
	}

	// 게시글 작성 폼
	@RequestMapping(value = "/insertForm", method = RequestMethod.POST)
	public String insertForm(Model model, BoardDTO boardDTO, HttpSession session) throws Exception {
		return "board/insertForm.tiles";

	}

	// 게시글 작성 로직
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(Model model, BoardDTO boardDTO, HttpSession session) throws Exception {
		boardService.boardInsert(boardDTO);

		return "redirect:/boardList";
	}

	// 게시글 상세보기
	@RequestMapping(value = "/boardDetail", method = RequestMethod.POST)
	public String boardDetail(Model model, BoardDTO boardDTO, HttpServletRequest req, HttpServletResponse res,
			HttpSession session) throws Exception {

		BoardDTO detail = boardService.boardDetail(boardDTO);
		
		if (detail.getResultCode().equals("9999")) {
			model.addAttribute("message",detail.getResultMsg());
						
			return this.boardList(model, boardDTO);
				
		}else {
			model.addAttribute("board", detail);
		}
		return "board/boardDetail.tiles";
	}
	// 게시글 수정 폼
	@RequestMapping(value = "/boardUpdateFrm", method = RequestMethod.POST)
	public String boardUpdateFrm(Model model, BoardDTO boardDTO) throws Exception {
		model.addAttribute("board", boardDTO);

		return "board/boardUpdate.tiles";
	}

	// 게시글 수정
	@RequestMapping(value = "/boardUpdate", method = RequestMethod.POST)
	public String boardUpdate(Model model, BoardDTO boardDTO) throws Exception {
		boardService.boardUpdate(boardDTO);

		return this.boardList(model, boardDTO);
	}

	// 게시글 삭제
	@RequestMapping(value = "/boardDelete", method = RequestMethod.POST)
	public void boardDelete(Model model, BoardDTO boardDTO) throws Exception {
		boardService.boardDelete(boardDTO);
	}
	
} 
