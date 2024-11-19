package com.ll;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
	public static void main(String[] args) {
		App app = new App();
		app.run();

	}
}

	class App{
        //목록을 출력하기 위해 등록된 리스트를 저장할 장소
		ArrayList<String> megs = new ArrayList<>();
		ArrayList<String> names = new ArrayList<>();

		public void run() {
			System.out.println("== 명언 앱 ==");

			//스캐너(System.in(키보드)를 스캔하는 객체 생성
			Scanner scanner = new Scanner(System.in);

			int cnt =0; //while문에 넣으면 반복마다 초기화가 된다.

			while (true) {

				System.out.print("명언) ");
				String cmd = scanner.nextLine();

				if(cmd.equals("등록")){
					System.out.print("명언: ");
					String meg = scanner.nextLine();

					System.out.print("작가: ");
					String name = scanner.nextLine();

					cnt++; //번호 증가
					megs.add(meg); //명언 리스트 추가
					names.add(name);

					System.out.println(cnt+"번 명언이 등록되었습니다. ");
				}



				else if(cmd.equals("목록")){
					System.out.println("번호 / 작가 / 명언");
					System.out.println("---------------------");
					for (int i = megs.size() - 1; i >= 0; i--) {
						System.out.println((megs.size() - i) + " / " + names.get(i) + " / " + megs.get(i));
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

