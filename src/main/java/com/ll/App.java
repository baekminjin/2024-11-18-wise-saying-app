package com.ll;

import com.ll.domain.wiseSaying.controller.WiseSayingController;
import com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App { //가게의 전체 틀
	private final Scanner scanner; //내부에서 사용하면 private
	private int lastId; //변하기 때문에 final 안 붙임
	private int lastld;
	private final List<WiseSaying> wiseSayings; //리스트
	private int wiseSayingsSize;
	private final WiseSayingController wiseSayingController;

	public App() { //열기전 가게 준비물
		scanner = new Scanner(System.in);
		lastId = 0;
		wiseSayingController = new WiseSayingController();
		wiseSayings = new ArrayList<>(); //리스트
		//ArrayList<WiseSaying> 리모콘의 버튼 개수가 더 많아진다. 하지만 버튼은 적을 수록 좋다.
	}

	//구체적인 일들
	public void run() {
		System.out.println("== 명언 앱 ==");

		makeSampleData();
		//등록하기 전 샘플을 보여준다.

		while (true) {
			System.out.print("명령) ");
			String cmd = scanner.nextLine();
			if (cmd.equals("종료")) {
				break;
			}


			else if (cmd.equals("등록")) {
				actionAdd();
			}


			else if (cmd.equals("목록")) {
				wiseSayingController.actionList(wiseSayings);
			}


			else if (cmd.startsWith("삭제?id=")) { //완벽하게 일치하지 않더라도 삭제하는 말이면 실행

				wiseSayingController.actionDelete(wiseSayings, cmd);
			}


			else if (cmd.startsWith("수정")) { //완벽하게 일치하지 않더라도 삭제하는 말이면 실행

				wiseSayingController.actionModify(scanner, wiseSayings, cmd);
			}
		}
		scanner.close();
	}




		private void makeSampleData() {
			addWiseSaying("나의 죽음을 적들에게 알리지 말라.", "이순신 장군");
			addWiseSaying("삶이 있는 한 희망은 있다.", "키케로");
		}


	private WiseSaying addWiseSaying(String content, String author) {
		int id = ++lastId;
		//새로운 명언 생성
		WiseSaying wiseSaying = new WiseSaying(id, content, author);

		wiseSayings.add(wiseSaying);

		wiseSayingsSize++;
		return wiseSaying;

	}
	private void actionAdd() {
		System.out.print("명언 : ");
		String content = scanner.nextLine();
		System.out.print("작가 : ");
		String author = scanner.nextLine();
		//새로운 명언 wiseSaying저장
		WiseSaying wiseSaying = addWiseSaying(content, author);
		System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
	}






}
