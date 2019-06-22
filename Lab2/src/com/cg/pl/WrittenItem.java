package com.cg.pl;

abstract class WrittenItem extends Item {

	private String author;
public WrittenItem() {
	// TODO Auto-generated constructor stub
}
	public WrittenItem(int id1, String title, String author2, int noCopies) {
	super(id1,title,noCopies);
	this.author=author2;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
}
