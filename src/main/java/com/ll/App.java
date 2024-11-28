package com.ll;

import com.ll.domain.wiseSaying.controller.WiseSayingController;
import com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App { //가게의 전체 틀
	private final Scanner scanner; //내부에서 사용하면 private
	 //리스트
	private final WiseSayingController wiseSayingController;

	public App() { //열기전 가게 준비물
		scanner = new Scanner(System.in);
		wiseSayingController = new WiseSayingController();

		//ArrayList<WiseSaying> 리모콘의 버튼 개수가 더 많아진다. 하지만 버튼은 적을 수록 좋다.
	}

	//구체적인 일들
	public void run() {
		System.out.println("== 명언 앱 ==");

		wiseSayingController.makeSampleData();
		//등록하기 전 샘플을 보여준다.

		while (true) {
			System.out.print("명령) ");
			String cmd = scanner.nextLine();
			if (cmd.equals("종료")) {
				break;
			}
			else if (cmd.equals("등록")) {
				wiseSayingController.actionAdd(scanner);
			}
			else if (cmd.equals("목록")) {
				wiseSayingController.actionList();
			}
			else if (cmd.startsWith("삭제?id=")) { //완벽하게 일치하지 않더라도 삭제하는 말이면 실행

				wiseSayingController.actionDelete(cmd);
			}
			else if (cmd.startsWith("수정")) { //완벽하게 일치하지 않더라도 삭제하는 말이면 실행

				wiseSayingController.actionModify(scanner,cmd);
			}
		}
		scanner.close();
	}







}
