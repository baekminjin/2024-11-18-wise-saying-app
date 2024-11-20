package com.ll;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
	public static void main(String[] args) {
		App app = new App(); //객체 생성
		app.run(); //run함수 호출

	}
}

	class App{ //템플릿
        //목록을 출력하기 위해 등록된 리스트를 저장할 장소
		ArrayList<String> contents = new ArrayList<>();
		ArrayList<String> authors = new ArrayList<>();

		public void run() {
			System.out.println("== 명언 앱 ==");

			//스캐너(System.in(키보드)를 스캔하는 객체 생성
			Scanner scanner = new Scanner(System.in);

			int cnt =0; //반복문에 넣으면 반복마다 초기화가 된다.

			while (true) {

				System.out.print("명언) ");
				String cmd = scanner.nextLine(); //키보드에서 입력한 것을 cmd로 저장

				if(cmd.equals("등록")){ //저장된 입력값 cmd와 비교
					System.out.print("명언: ");
					String content = scanner.nextLine();//입력 값 meg 저장

					System.out.print("작가: ");
					String author = scanner.nextLine(); //입력 값 name 저장

					int id = ++cnt; // 위의 입력이 끝날 시 번호 증가

					WiseSaying wiseSaying = new WiseSaying();
					wiseSaying.id = id; //힙에다 값을 전달
					wiseSaying.content = content;
					wiseSaying.author = author;

					contents.add(content); //명언 리스트 추가
					authors.add(author);

					System.out.println(id+"번 명언이 등록되었습니다. ");
				}



				else if(cmd.equals("목록")){
					System.out.println("번호 / 작가 / 명언");
					System.out.println("---------------------");
					for (int i = 0; i< contents.size(); i++) {
						System.out.println((contents.size() - i) + " / " + authors.get(contents.size()-1-i)+ " / " + contents.get(contents.size()-1-i));
				}
				}


				else if (cmd.equals("종료")) {
					break; //while 분기 종료
				}
}

//System.out.println("입력된 명령어 : %s".formatted(cmd));

			scanner.close();

		}
	}

//한꺼번에 옮기기 위해
		class WiseSaying {
			int id;
			String content;
			String author;
		}

