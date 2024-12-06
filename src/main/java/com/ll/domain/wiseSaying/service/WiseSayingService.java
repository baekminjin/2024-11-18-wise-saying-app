package com.ll.domain.wiseSaying.service;

import com.ll.domain.wiseSaying.entity.WiseSaying;
import com.ll.domain.wiseSaying.repository.WiseSayingRepository;

import java.util.List;
import java.util.Optional;

public class WiseSayingService {
	private final WiseSayingRepository wiseSayingRepository;

	public WiseSayingService() {
		this.wiseSayingRepository = new WiseSayingRepository();
	}

	public WiseSaying add(String content, String author) {//addwisesaying에서 add로 이름 바꿈
		WiseSaying wiseSaying = new WiseSaying(0, content, author); //요리 만들기

		wiseSayingRepository.add(wiseSaying); //리포지터리 저장

		return wiseSaying;
	}

	public List<WiseSaying> findAll() {
		return wiseSayingRepository.findAll();
	}

	public boolean removeById(int id) {
		return wiseSayingRepository.removeById(id);
	}

	public Optional<WiseSaying> findById(int id) {
		return wiseSayingRepository.findById(id);
	}

	public void modify(WiseSaying wiseSaying, String content, String author) {
		wiseSaying.setContent(content);
		wiseSaying.setAuthor(author);

		wiseSayingRepository.modify(wiseSaying);
	}
}