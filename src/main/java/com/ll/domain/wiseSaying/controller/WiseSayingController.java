package com.ll.domain.wiseSaying.controller;

import com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
	public void actionList(List<WiseSaying> wiseSayings) {
		System.out.println("번호 / 작가 / 명언");
		System.out.println("----------------------");
		//거꾸로된 리스트 하나하나를 건내고 비교
		for (WiseSaying wiseSaying : wiseSayings.reversed()) {
			//if (wiseSaying == null) break;
			System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent()));
		}
	}

	public void actionDelete(List<WiseSaying> wiseSayings, String cmd) {
		String idStr = cmd.substring(6); //6번째 요소 가져오기
		int id = Integer.parseInt(idStr); //정수화

		boolean removed = wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);
		//
		if(removed)
			System.out.println(id+"번 명언을 삭제했습니다.");

		else System.out.println(id+"번 명언은 존재하지 않습니다.");
	}

	public void actionModify(Scanner scanner, List<WiseSaying> wiseSayings, String cmd) {
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
