package com.ll.domain.wiseSaying.service;

import com.ll.domain.wiseSaying.entity.WiseSaying;
import com.ll.domain.wiseSaying.repository.WiseSayingMemoryRepository;
import com.ll.domain.wiseSaying.repository.WiseSayingRepository;

import java.util.List;
import java.util.Optional;

public class WiseSayingService {
	private final WiseSayingRepository wiseSayingRepository;

	public WiseSayingService() {
		this.wiseSayingRepository = new WiseSayingMemoryRepository();
		//약속을 기반으로 움직이기 때문에 약속을 충족하는 행동양식들을 바꾸지 않는다.

	}

	//행동양식 //교체를 해도 행동양식은 변하지 않기 때문에 영향이 없다.
	public WiseSaying add(String content, String author) {
		WiseSaying wiseSaying = new WiseSaying(0, content, author);

		wiseSayingRepository.add(wiseSaying);

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