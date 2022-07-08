package kr.co.file.view;

import kr.co.file.annotation.AnnotationHandler;
import kr.co.file.annotation.RequestMapping;
import kr.co.file.util.ScanUtil;

public class MainView {
	
	AnnotationHandler anno = new AnnotationHandler();
	
	// 메인 메뉴
	public void view() {
		System.out.println("========== File Manager ==========");
		System.out.println("| \t 1. 파일 조회 \t\t |");
		System.out.println("| \t 2. 파일 생성 \t\t |");
		System.out.println("| \t 3. 파일 삭제 \t\t |");
		System.out.println("| \t 4. 파일 내용 읽기 \t |");
		System.out.println("| \t 5. 파일 내용 쓰기 \t |");
		System.out.println("| \t 6. 지하철역 검색 \t |");
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
						anno.action("/file/list");
						System.out.println("-------------------------------");
						returnView();
					case 2:
						System.out.println("---------- 파일 생성 ----------");
						anno.action("/file/create");
						System.out.println("-------------------------------");
						returnView();
					case 3:
						System.out.println("---------- 파일 삭제 ----------");
						anno.action("/file/delete");
						System.out.println("-------------------------------");
						returnView();
					case 4:
						System.out.println("------- 파일 내용 읽기 -------");
						anno.action("/file/content/read");
						System.out.println("------------------------------");
						returnView();
					case 5:
						System.out.println("------- 파일 내용 쓰기 -------");
						anno.action("/file/content/write");
						System.out.println("------------------------------");
						returnView();
					case 6:
						System.out.println("------- 지하철역 조회 -------");
						anno.action("/subway/list");
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
	
	@RequestMapping(url = "/test/a")
	public void test() throws Exception {
		System.out.println("이게 되나?");
		System.out.println("호옥시~?");
	}
	
}
