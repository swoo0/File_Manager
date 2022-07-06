package file_manager.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import file_manager.util.ScanUtil;

public class FileService {

	private String path = "d:/File/";		// 파일 경로
	private String extension = ".txt";		// 파일 확장자
	
	private static FileService instance;
	
	private FileService() {}
	
	public static FileService getInstance() {
		if (instance == null) {
			instance = new FileService();
		}
		return instance;
	}
	
	
	// 파일 리스트 조회
	public void readFiles() throws Exception {
		
		File directory = new File("D:/File/");
		File[] directoryFiles = directory.listFiles();

		for (int i = 0; i < directoryFiles.length; i++) {
			System.out.println(directoryFiles[i].getName());
		}
	
	}
	
	
	// 파일 생성
	public void createFile() throws Exception {
		
		System.out.print("파일명을 입력해주세요 >> ");
		String fileName = ScanUtil.nextLine();
		
		// 파일 생성
		File file = new File(path + fileName + extension);
		
		if (file.createNewFile()) {
			System.out.println("파일명 : " + file.getName());
			System.out.println(file.getName() + " 만들기 성공!");
			System.out.println("------------------------------------");
		} else {
			System.out.println(file.getName() + " 만들기 실패!!!");
		}
	}
	
	// 파일 삭제
	public void deleteFile() throws Exception {
		
		System.out.print("파일명을 입력해주세요 >> ");
		String fileName = ScanUtil.nextLine();
		
		File file = new File(path + fileName + extension); 
	
		if (file.delete()) {
			System.out.println(file.getName() + " 삭제 성공!");
			System.out.println("------------------------------------");
		} else {
			System.out.println(file.getName() + " 삭제 실패!!!");
			System.out.println("------------------------------------");
		}
	}
	
	
	// 파일 내용 읽기
	public void readFileContent() throws Exception {
		
		FileReader fr = null;
		BufferedReader br = null;
		
		System.out.print("파일명을 입력해주세요 >> ");
		String fileName = ScanUtil.nextLine();
		
		try {
			fr = new FileReader(path + fileName + extension);
			
//			한줄씩 읽을 수 있도록 해주는 readline 메서드를 이용하기 위해
//			BufferedReader 사용함.
			br = new BufferedReader(fr);
			String temp = "";
			System.out.println("파일명 : " + fileName);
			System.out.println("내용 : ");
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
	
	// 파일 쓰기 
	public void writeFileContent() throws Exception {
		
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
			
			bos.flush(); // 작업을 종료하기 전에 버퍼에 남아있는 데이터를 모두
			// 출력시킨다. (close시 자동으로 호출됨)
		
			System.out.println("작업 끝 !");

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
