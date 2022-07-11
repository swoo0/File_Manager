package kr.co.file.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import kr.co.file.util.ScanUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileServiceImpl implements FileService {

	// 필드 선언
	private String path = "D:/Project/Study/file/fol/";		// 파일 경로
	private String extension = ".txt";		// 파일 확장자

	private static FileService fileService;
	
	// 생성자 선언
	private FileServiceImpl() {
	}
	
	public static FileService getInstance() {
		if (fileService == null) {
			fileService = new FileServiceImpl();
		}
		return fileService;
	}

	// 메소드
	public void getFileList() throws IOException {
		File directory = new File(path);
		File[] directoryFiles = directory.listFiles();

		for (int i = 0; i < directoryFiles.length; i++) {
//			System.out.println(directoryFiles[i].getName());
			log.info("파일명 : " + directoryFiles[i].getName());
		}
		if (directoryFiles.length == 0) {
			System.out.println("파일이 존재하지 않습니다.");
		}
		
	}

	public void createFile() throws IOException {
		System.out.print("파일명을 입력해주세요 >> ");
		String fileName = ScanUtil.nextLine();
		
		// 파일 생성
		File file = new File(path + fileName + extension);
		
		if (file.createNewFile()) {
			log.info("파일명 : " + file.getName() + " 생성 완료!");
		} else {
			log.info("파일명 : " + file.getName() + " 생성 실패!");
			log.info("동일한 파일명이 존재합니다 !");
		}
	}

	public void deleteFile() throws IOException {
		System.out.print("파일명을 입력해주세요 >> ");
		String fileName = ScanUtil.nextLine();
		
		File file = new File(path + fileName + extension); 
	
		if (file.delete()) {
			log.info(file.getName() + " 삭제 성공!");
		} else {
			log.info(file.getName() + " 삭제 실패!");
			log.info(file.getName() + " 파일이 존재하지 않습니다.");
		}
	}

	public void readFileContent() throws IOException {
		FileReader fr = null;
		BufferedReader br = null;
		
		System.out.print("파일명을 입력해주세요 >> ");
		String fileName = ScanUtil.nextLine();
		
		try {
			fr = new FileReader(path + fileName + extension);
			// 한줄씩 읽을 수 있도록 해주는 readline 메서드를 이용하기 위해 BufferedReader 사용.
			br = new BufferedReader(fr);
			String temp = "";
			log.info("파일명 : " + fileName);
			log.info("내용 : ");
			for (int i = 1; (temp = br.readLine()) != null; i++) {
				log.info(temp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void writeFileContent() throws IOException {
		FileWriter fw = null;
		BufferedWriter bos = null;
		
		System.out.print("파일명을 입력해주세요 >> ");
		String fileName = ScanUtil.nextLine();
		
		try {
			fw = new FileWriter(path + fileName + extension, true);
			
			// 버퍼 크기가 5인 스트림 생성
			bos = new BufferedWriter(fw, 5);
			
			System.out.print("내용을 입력하세요 >> ");
			String content = ScanUtil.nextLine();
			
			bos.write(content);
			bos.flush();
		
			System.out.println("쓰기 완료 !");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bos.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
}
