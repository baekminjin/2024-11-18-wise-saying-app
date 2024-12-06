package com.ll.domain.wiseSaying.repository;

import com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.List;
import java.util.Optional;

//약속
public interface WiseSayingRepository {
	void add(WiseSaying wiseSaying);

	List<WiseSaying> findAll();

	boolean removeById(int id);

	Optional<WiseSaying> findById(int id);

	void modify(WiseSaying wiseSaying);
}