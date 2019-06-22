package com.cg.pl;

public class CD extends MediaItem{
	
	public CD(int bookId, String title, int noCopies, int runtime) {
		super(bookId, title, noCopies, runtime);
		// TODO Auto-generated constructor stub
	}

	private String artist;
	private String cdgenre;

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
