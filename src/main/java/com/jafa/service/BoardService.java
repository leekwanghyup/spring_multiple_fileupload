package com.jafa.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.jafa.common.FileUploadUtils;
import com.jafa.domain.AttachVO;
import com.jafa.domain.BoardVO;
import com.jafa.repository.AttachRepository;
import com.jafa.repository.BoardRepository;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BoardService {
	
	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	AttachRepository attachRepository;
	
	@Autowired
	FileUploadUtils fileUploadUtils;
	
	@Transactional
	public void write(BoardVO vo, MultipartFile[] multipartFiles) {
		boardRepository.write(vo); // 게시물 정보 데이터베이스 저장 
		List<AttachVO> attachVOList = fileUploadUtils.getAttachVOList(vo.getBno(), multipartFiles);
		if(!attachVOList.isEmpty()) { // 첨부파일이 있으면 
			attachRepository.save(attachVOList); // 첨부파일정보리스트 데이터베이스 저장
			boardRepository.upadteAttachFileCnt(vo.getBno()); // 첨부파일 개수 저장 
		}
	}
	
	public List<BoardVO> list(){
		return boardRepository.list();
	}

	public BoardVO detail(Long bno) {
		return boardRepository.get(bno);
	}
}
