package com.jafa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jafa.domain.BoardVO;
import com.jafa.repository.BoardRepository;
import com.jafa.service.AttachService;
import com.jafa.service.BoardService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	AttachService attachService;
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", boardService.list());
	}
	
	@GetMapping("/detail")
	public void detail(Long bno, Model model) {
		BoardVO detail = boardService.detail(bno);
		model.addAttribute("b", boardService.detail(bno));
		if(detail.getAttachFileCnt()>0) { // 첨부파일이 있을 때 첨부파일리스트를 가져옴
			model.addAttribute("attachList", attachService.list(bno));
		}
	}
	
	@GetMapping("/write")
	public void write() {
		
	}
	
	@PostMapping("/write")
	public String write(BoardVO boardVO, @RequestParam("attachFile")  MultipartFile[] multipartFiles) {
		boardService.write(boardVO, multipartFiles);
		return "redirect:/board/list";
	}
	
}
