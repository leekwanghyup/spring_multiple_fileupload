package com.jafa.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardVO {
	Long bno; 
	String title; 
	String content; 
	String writer;
	Integer attachFileCnt;
	List<AttachVO> attachVO;
}
