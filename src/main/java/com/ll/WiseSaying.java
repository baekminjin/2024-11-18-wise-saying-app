package com.ll;

public class WiseSaying {
	private final int id; //사용자가 값을 정해주는 것을 막아준다.
	private String content;
	private String author;

	public WiseSaying(int id, String content, String author) {
		this.id = id;
		this.content = content;
		this.author = author;
	}

	public int getId(){ //원본 복사/읽기만 가능/읽기,수정등 많은 내용?을 가지고 있어서
		return id;
	}

	public String getContent(){
		return content;
	}

	public String getAuthor(){
		return author;
	}
/*
	@Override
	public String toString() {
		return "WiseSaying (id=%d, content=\"%s\", author=\"%s\")".formatted(id, content, author);
	}

 */
}
