package com.cg.pl;

import java.util.HashMap;
import java.util.Map;


abstract class Item {
	
	private int bookId;
	private String title;
	private int noCopies;
	
	Map<Integer, Item> bookList=new HashMap<>();
	
	public Item() {
		// TODO Auto-generated constructor stub
		
	}
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNoCopies() {
		return noCopies;
	}
	public void setNoCopies(int noCopies) {
		this.noCopies = noCopies;
	}

	@Override
	public String toString() {
		return "Item [bookId=" + bookId + ", title=" + title + ", noCopies=" + noCopies + "]";
	}

	public Item(int bookId, String title, int noCopies) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.noCopies = noCopies;
	}




	public abstract void checkIn(int bookId);
	public abstract void checkOut(int bookId);//
	public abstract Item addItem(int id1, String title, String author, int noCopies);//
	public abstract void print();//
	
}
