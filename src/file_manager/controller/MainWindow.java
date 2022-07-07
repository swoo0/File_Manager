package file_manager.controller;

import file_manager.service.FileServiceImpl;
import file_manager.util.ScanUtil;

public class MainWindow {
	
	// 필드
	private FileServiceImpl fileService = FileServiceImpl.getInstance();
	
	
	// 메인 메뉴
	public void view() {
		System.out.println("========== File Manager ==========");
		System.out.println("| \t 1. 파일 조회 \t\t |");
		System.out.println("| \t 2. 파일 생성 \t\t |");
		System.out.println("| \t 3. 파일 삭제 \t\t |");
		System.out.println("| \t 4. 파일 내용 쓰기 \t |");
		System.out.println("| \t 5. 파일 내용 읽기 \t |");
		System.out.println("| \t 0. 시스템 종료 \t |");
		System.out.println("==================================");

		// 선택지
		try {
			while (true) {
				System.out.print("어떤 서비스를 이용하시겠습니까? >> ");
				int menu = ScanUtil.nextInt();
				switch (menu) {
					case 1:
						System.out.println("---------- 파일 목록 ----------");
						fileService.readFileList();
						System.out.println("-------------------------------");
						returnView();
					case 2:
						System.out.println("---------- 파일 생성 ----------");
						fileService.createFile();
						System.out.println("-------------------------------");
						returnView();
					case 3:
						System.out.println("---------- 파일 삭제 ----------");
						fileService.deleteFile();
						System.out.println("-------------------------------");
						returnView();
					case 4:
						System.out.println("------- 파일 내용 쓰기 -------");
						fileService.writeFileContent();
						System.out.println("------------------------------");
						returnView();
					case 5:
						System.out.println("------- 파일 내용 읽기 -------");
						fileService.readFileContent();
						System.out.println("------------------------------");
						returnView();
					case 0:
						System.out.println("시스템을 종료합니다..");
						break;
					default:
						System.out.println("올바른 입력 형식이 아닙니다!");
						continue;
				}
				break;
			}
		} catch (Exception e) {
			System.out.println("올바른 입력형식이 아닙니다!");
			view();
		}

	}
	
	// 홈화면으로 선택 이동
	public void returnView() throws Exception {
		System.out.print("메뉴로 돌아가시려면 1번을 입력해주세요 >> ");
		int select = ScanUtil.nextInt();
		if (select == 1) {
			view();
		}
	}
	
	
	
}
