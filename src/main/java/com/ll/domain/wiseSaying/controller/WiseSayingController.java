package com.ll.domain.wiseSaying.controller;

import com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
	private final List<WiseSaying> wiseSayings;
    //변수를 유지한 상태에 공유가 안되기 때문에 컨트롤러에서 실행한다.
	private int lastId; //변하기 때문에 final 안 붙임


	public WiseSayingController() {
		this.wiseSayings = new ArrayList<>();
		this.lastId=0;
	}

	private WiseSaying addWiseSaying(String content, String author) {

		int id = ++lastId;
		//새로운 명언 생성
		WiseSaying wiseSaying = new WiseSaying(id, content, author);

		wiseSayings.add(wiseSaying);


		return wiseSaying;

	}
	public void actionAdd(Scanner scanner) {
		System.out.print("명언 : ");
		String content = scanner.nextLine();
		System.out.print("작가 : ");
		String author = scanner.nextLine();
		//새로운 명언 wiseSaying저장
		WiseSaying wiseSaying = addWiseSaying(content, author);
		System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
	}


	public void makeSampleData() {
		addWiseSaying("나의 죽음을 적들에게 알리지 말라.", "이순신 장군");
		addWiseSaying( "삶이 있는 한 희망은 있다.", "키케로");
	}


	public void actionList() {
		System.out.println("번호 / 작가 / 명언");
		System.out.println("----------------------");
		//거꾸로된 리스트 하나하나를 건내고 비교
		for (WiseSaying wiseSaying : wiseSayings.reversed()) {
			//if (wiseSaying == null) break;
			System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent()));
		}
	}

	public void actionDelete(String cmd) {
		String idStr = cmd.substring(6); //6번째 요소 가져오기
		int id = Integer.parseInt(idStr); //정수화

		boolean removed = wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);
		//
		if(removed)
			System.out.println(id+"번 명언을 삭제했습니다.");

		else System.out.println(id+"번 명언은 존재하지 않습니다.");
	}

	public void actionModify(Scanner scanner,String cmd) {
		String idStr = cmd.substring(6);

		int id = Integer.parseInt(idStr); //정수화

		WiseSaying foundWiseSaying = null;

		for (WiseSaying wiseSaying : wiseSayings) {
			if (wiseSaying.getId() == id) {
				//참조
				foundWiseSaying = wiseSaying;
				break; //반복문 종료
			}
		}

		if (foundWiseSaying == null) { //존재하면 다음 코드
			System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
			return;
		}

		System.out.println("명언(기존) : %s".formatted(foundWiseSaying.getContent()));
		System.out.print("명언 : ");
		String content = scanner.nextLine();

		System.out.println("작가(기존) : %s".formatted(foundWiseSaying.getAuthor()));
		System.out.print("작가 : ");
		String author = scanner.nextLine();

		foundWiseSaying.setContent(content);
		foundWiseSaying.setAuthor(author);

		System.out.println("%d번 명언이 수정되었습니다.".formatted(id));
	}



}
