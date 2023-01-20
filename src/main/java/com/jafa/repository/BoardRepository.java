package com.jafa.repository;

import java.util.List;

import com.jafa.domain.BoardVO;

public interface BoardRepository {

	List<BoardVO> list(); 
	
	void write(BoardVO vo);

	BoardVO get(Long bno);
	
	// 첨부파일 개수 업데이트 
	void upadteAttachFileCnt(Long bno);
}
