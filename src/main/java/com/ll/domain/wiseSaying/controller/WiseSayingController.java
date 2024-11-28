package com.ll.domain.wiseSaying.controller;

import com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.List;

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
}
