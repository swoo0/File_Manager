package kr.co.file.service;

import java.io.IOException;

public interface FileService {

	// 파일 목록 조회
	public void getFileList() throws IOException;
	
	// 파일 생성
	public void createFile() throws IOException;
	
	// 파일 삭제
	public void deleteFile() throws IOException;
	
	// 파일 내용 읽기
	public void readFileContent() throws IOException;
	
	// 파일 쓰기
	public void writeFileContent() throws IOException;
	
	

}
