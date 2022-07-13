package kr.co.file.view;

import kr.co.file.annotation.AnnotationHandler;
import kr.co.file.util.ScanUtil;

public class MainView {
	
	private AnnotationHandler anno = new AnnotationHandler();
	
	// 메인 메뉴
	public void view() {
		System.out.println("========== File Manager ==========");
		System.out.println("| \t 1. 파일 조회 \t\t |");
		System.out.println("| \t 2. 파일 생성 \t\t |");
		System.out.println("| \t 3. 파일 삭제 \t\t |");
		System.out.println("| \t 4. 파일 내용 읽기 \t |");
		System.out.println("| \t 5. 파일 내용 쓰기 \t |");
		System.out.println("| \t 6. 지하철역 검색 \t |");
		System.out.println("| \t 7. 패키지 테스트 \t |");
		System.out.println("| \t 0. 시스템 종료 \t |");
		System.out.println("==================================");
		
		// 선택지
		try {
			while (true) {
				System.out.print("어떤 서비스를 이용하시겠습니까? >> ");
				String menu = ScanUtil.nextLine();
				
				if (menu.equals("0")) {
					break;
				} else if (Integer.parseInt(menu) > 0 && Integer.parseInt(menu) <= 7) {
					anno.action(menu);
					returnView();
				} else {
					System.err.println("해당 서비스는 존재하지 않습니다.");
				}
			}
		} catch (Exception e) {
//			e.printStackTrace();
			System.err.println("올바른 입력형식이 아닙니다!");
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
