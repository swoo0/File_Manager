package file_manager.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import file_manager.util.ScanUtil;

public class FileServiceImpl implements FileService {

	// 필드 선언
	private String path = "D:/File/";		// 파일 경로
	private String extension = ".txt";		// 파일 확장자

	private static FileServiceImpl fileService;
	
	// 생성자 선언
	private FileServiceImpl() {}
	
	public static FileServiceImpl getInstance() {
		if (fileService == null) {
			fileService = new FileServiceImpl();
		}
		return fileService;
	}

	// 메소드
	public void readFileList() throws IOException {
		File directory = new File(path);
		File[] directoryFiles = directory.listFiles();

		for (int i = 0; i < directoryFiles.length; i++) {
			System.out.println(directoryFiles[i].getName());
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
			System.out.println("파일명 : " + file.getName());
			System.out.println("파일 생성 성공!");
		} else {
			System.out.println(file.getName() + " 파일 생성 실패!!!");
			System.out.println("동일한 파일명이 존재합니다.");
		}
	}

	public void deleteFile() throws IOException {
		System.out.print("파일명을 입력해주세요 >> ");
		String fileName = ScanUtil.nextLine();
		
		File file = new File(path + fileName + extension); 
	
		if (file.delete()) {
			System.out.println(file.getName() + " 삭제 성공!");
		} else {
			System.out.println(file.getName() + " 삭제 실패!!!");
			System.out.println(file.getName() + "파일이 존재하지 않습니다.");
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
			System.out.println("파일명 : " + fileName);
			System.out.print("내용 : ");
			for (int i = 1; (temp = br.readLine()) != null; i++) {
//				System.out.printf("%4d : %s\n", i, temp);
				System.out.println(temp); 
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
			
			// 버퍼의 크기를 지정하지 않으면 기본적으로 버퍼의 크기가
			// 8192byte(8KB)로 설정된다.
			
			// 버퍼 크기가 5인 스트림 생성
			bos = new BufferedWriter(fw, 5);
			
			System.out.print("내용을 입력하세요 >> ");
			String content = ScanUtil.nextLine();
			
			bos.write(content);
			
			bos.flush(); // 작업을 종료하기 전에 버퍼에 남아있는 데이터를 모두 출력시킨다. (close시 자동으로 호출됨)
		
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
