package com.cg.pl;

public class JournalPaper extends WrittenItem{

	public JournalPaper(int id1, String title, String author2, int noCopies,int publishedYear) {
		super(id1, title, author2, noCopies);
		this.publishedYear=publishedYear;
		// TODO Auto-generated constructor stub
	}

	private int publishedYear;

	@Override
	public void checkIn(int bookId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkOut(int bookId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Item addItem(int id1, String title, String author, int noCopies) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
	
	
}
