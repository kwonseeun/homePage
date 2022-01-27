package com.base.exam.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.base.exam.web.dto.CommentDTO;
import com.base.exam.web.dto.Search;
import com.base.exam.web.dto.TestDTO;
import com.base.exam.web.service.TestService;

@Controller
@RequestMapping(value="/board")
public class TestController {

	@Autowired
	private TestService testService;
	
	@RequestMapping(value="/getBoardList", method = RequestMethod.GET)
	public String getBoardList(Model model, @RequestParam(required = false, defaultValue= "1")int page, @RequestParam(required = false, defaultValue= "1")int range, @RequestParam(required = false, defaultValue = "title") String searchType
							, @RequestParam(required = false) String keyword
							, @ModelAttribute("search") Search search) throws Exception{
		
		// 검색
		model.addAttribute("search", search);
		search.setSearchType(searchType);
		search.setKeyword(keyword);
		
		// 전체 게시글 개수
		int listCnt = testService.getBoardListCnt(search);

		// 검색
		search.pageInfo(page, range, listCnt);
		
		// 페이징 
		model.addAttribute("pagenation", search);
		
		//게시글 화면 출력 
		model.addAttribute("boardList", testService.getBoardList(search));
		
		return "board/index.pop";
		
	}
	
	@RequestMapping(value="/boardForm", method = RequestMethod.POST) 
	public String boardForm(Model model,@ModelAttribute("testDTO") TestDTO testDTO) throws Exception{
		System.out.println("boardForm 실행 . . . ");
		
		return "test/boardForm";
	}
	
	@RequestMapping(value="/getBoardContent",method=RequestMethod.POST)
	public String getBoardContent(Model model, @RequestParam("bid") int bid) throws Exception{
		System.out.println("getBoardContent 실행 . . . ");
		
		model.addAttribute("boardContent", testService.getBoardContent(bid));
		model.addAttribute("CommentDTO", new CommentDTO());
		
		return "test/getBoardContent";
	}
	
	@RequestMapping(value="/editForm", method=RequestMethod.GET)
	public String editForm(Model model,@RequestParam("bid") int bid, @RequestParam("mode") String mode) throws Exception {
		System.out.println(">>>>>>>>> editForm 실행 . . . ");
		
		model.addAttribute("boardContent", testService.getBoardContent(bid));
		model.addAttribute("mode", mode);
		model.addAttribute("testDTO", new TestDTO());
		
		return "test/boardForm" ;
	}
	
	@RequestMapping(value="/saveBoard", method=RequestMethod.POST)
	public String saveBoard(@ModelAttribute("testDTO") TestDTO testDTO, @RequestParam("mode") String mode, RedirectAttributes rttr) throws Exception {
		System.out.println(">>>>>>>> saveBoard 실행 . . . ");
		
		if (mode.equals("edit")) {
			testService.updateBoard(testDTO);
		} else {
			testService.insertBoard(testDTO);
		}
		return "redirect:/board/getBoardList";
	}
	
	@RequestMapping(value="/deleteBoard", method=RequestMethod.POST)
	public String deleteBoard(@RequestParam("bid")int bid,RedirectAttributes rttr)throws Exception{
		System.out.println(">>>>>> deleteBoard 실행 . . . ");		
		testService.deleteBoard(bid);

		return "redirect:/board/getBoardList";
	}
	
	
	// ### 댓글 목록 ###

	@ResponseBody
	@RequestMapping(value="/getReplyList", method = RequestMethod.POST)
	public List<CommentDTO> getReplyList(@RequestParam("bid")int bid) throws Exception{
		return testService.getReplyList(bid);
	}
	
	// ### 댓글 등록 ### 
	
	@ResponseBody
	@RequestMapping(value="/saveReply", method= RequestMethod.POST)
	public Map<String,Object> saveReply(@RequestBody CommentDTO commentDTO) throws Exception{
		Map<String,Object> result = new HashMap<>();
		
		try {
			testService.saveReply(commentDTO);
			result.put("resultMsg", "성공하였습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("resultMsg", "실패하였습니다.");
		}
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/updateReply", method= RequestMethod.POST)
	public Map<String,Object> updateReply(@RequestBody CommentDTO commentDTO) throws Exception{
		Map<String,Object> result = new HashMap<>();
		
		try {
		testService.updateReply(commentDTO);
		result.put("resultMsg", "성공하였습니다.");
		} catch (Exception e) {
		e.printStackTrace();
		result.put("resultMsg", "실패하였습니다.");
		}
		return result;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/deleteReply", method=RequestMethod.POST)
	public Map<String,Object> deleteReply(@RequestParam("rid")int rid) throws Exception{
		
		Map<String,Object> result = new HashMap<>();
		try {
			testService.deleteReply(rid);
			result.put("resultMsg", "성공하였습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("resultMsg","실패하였습니다.");
		}
		return result;
	}

	 
}
