package com.ll.domain.wiseSaying.controller;

import com.ll.domain.wiseSaying.entity.WiseSaying;
import com.ll.domain.wiseSaying.service.WiseSayingService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class WiseSayingController {
	private final WiseSayingService wiseSayingService;
	private final Scanner scanner;

	public WiseSayingController(Scanner scanner) {
		this.wiseSayingService = new WiseSayingService();
		this.scanner = scanner;
	}

	public void makeSampleData() {
		wiseSayingService.addWiseSaying("나의 죽음을 적들에게 알리지 말라.", "이순신 장군");
		wiseSayingService.addWiseSaying("삶이 있는 한 희망은 있다.", "키케로");
	}

	public void actionAdd() {
		System.out.print("명언 : ");
		String content = scanner.nextLine();
		System.out.print("작가 : ");
		String author = scanner.nextLine();

		WiseSaying wiseSaying = wiseSayingService.addWiseSaying(content, author);

		System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
	}

	public void actionList() {
		System.out.println("번호 / 작가 / 명언");
		System.out.println("----------------------");

		List<WiseSaying> wiseSayings = wiseSayingService.findAll();
		//findAll은 전부 찾아오라는 함수이다.

		for (WiseSaying wiseSaying : wiseSayings.reversed()) {
			System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent()));
		}
	}

	public void actionDelete(String cmd) {
		String idStr = cmd.substring(6);
		int id = Integer.parseInt(idStr);

		boolean removed = wiseSayingService.removeById(id);

		if (removed) System.out.println("%d번 명언을 삭제했습니다.".formatted(id));
		else System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
	}



	public void actionModify(String cmd) {
		String idStr = cmd.substring(6);
		int id = Integer.parseInt(idStr);

		Optional<WiseSaying> opWiseSaying = wiseSayingService.findById(id);
		//특정 타입의 값이 존재할 수도 있고 존재하지 않을 수도 있음 (스트림)

		if (opWiseSaying.isEmpty()) { //없을 때
			System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
			return;
		}

		//있으면 가져와서 넘겨준다.
		WiseSaying foundWiseSaying = opWiseSaying.get();

		System.out.println("명언(기존) : %s".formatted(foundWiseSaying.getContent()));
		System.out.print("명언 : ");
		String content = scanner.nextLine();

		System.out.println("작가(기존) : %s".formatted(foundWiseSaying.getAuthor()));
		System.out.print("작가 : ");
		String author = scanner.nextLine();

		wiseSayingService.modify(foundWiseSaying, content, author);

		System.out.println("%d번 명언이 수정되었습니다.".formatted(id));
	}
}