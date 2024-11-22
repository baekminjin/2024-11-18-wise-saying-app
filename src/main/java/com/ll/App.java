package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	private final Scanner scanner;
	private int lastId; //변하기 때문에 final 안 붙임
	private final List<WiseSaying> wiseSayings; //리스트
	private int wiseSayingsSize;
	public App() {
		scanner = new Scanner(System.in);
		lastId = 0;

		wiseSayings = new ArrayList<>(); //리스트
		//ArrayList<WiseSaying> 리모콘의 버튼 개수가 더 많아진다. 하지만 버튼은 적을 수록 좋다.
	}
	public void run() {
		System.out.println("== 명언 앱 ==");

		makeSampleData();
		//등록하기 전 샘플을 보여준다.

		while (true) {
			System.out.print("명령) ");
			String cmd = scanner.nextLine();
			if (cmd.equals("종료")) {
				break;
			} else if (cmd.equals("등록")) {
				actionAdd();
			} else if (cmd.equals("목록")) {
				actionList();
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
		WiseSaying wiseSaying = addWiseSaying(content, author);
		System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
	}
	private void actionList() {
		System.out.println("번호 / 작가 / 명언");
		System.out.println("----------------------");
		for (WiseSaying wiseSaying : wiseSayings) {
			if (wiseSaying == null) break;
			System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent()));
		}
	}
}
