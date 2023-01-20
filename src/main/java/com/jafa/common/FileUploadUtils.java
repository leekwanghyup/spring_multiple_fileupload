package com.jafa.common;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.jafa.domain.AttachVO;
import com.jafa.domain.FileType;

@Component
public class FileUploadUtils {
	
	private final static String UPLOAD_FOLDER = "c:/file02_repo";

	// 첨부파일 정보객체 생성 후 업로드
	public List<AttachVO> getAttachVOList(Long bno, MultipartFile[] multipartFiles){
		List<AttachVO> attachList = new ArrayList<AttachVO>(); // AttachVO객체 리스트 
		for(MultipartFile m : multipartFiles) { // MultipartFile[] 배열 반복
			if(!m.isEmpty()) { // MultipartFile객체에 파일이 있으면 
				AttachVO attachVO = AttachVO.builder() // AttachVO 객체 정보 생성
						.bno(bno)
						.fileName(m.getOriginalFilename()) // 파일이름 지정
						.filePath(getFilePath(bno,m.getOriginalFilename())) // 파일 경로 지정
						.fileType(getFileType(m.getContentType())) // 파일타입 지정
						.build();
				attachList.add(attachVO);
				
				// 파일 업로드 
				try {
					File folder = new File(getUploadPath(bno)); // 업로드 폴더  
					File file = new File(attachVO.getFilePath()); // 파일 경로
					if(!folder.exists()) folder.mkdirs(); // 업로드 경로 생성 
					m.transferTo(file); // 파일 전송
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				} 
			} // if end
		} // for end
		return attachList; 
	}
	
	// 업로드 폴더 경로
	private String getUploadPath(Long bno) {
		return UPLOAD_FOLDER +"/board/"+bno; 
	}
	
	// 업로드 파일 경로 생성
	private String getFilePath(Long bno,String fileName) {
		// 게시물 번호와 랜덤문자를 사용해서 파일경로 생성 
		return UPLOAD_FOLDER +"/board/"+bno+"/"+UUID.randomUUID().toString()+"_"+fileName; 
	}
	
	// 파일 타입 결정
	private FileType getFileType(String contentType) {
		if(contentType.startsWith("image")) return FileType.IMAGE; // 이미지파일 타입
		else return FileType.OTHER; // 이미지 이외 파일 타입
	}
}
