package com.example.bookstoreproject.globalData;

import java.util.ArrayList;
import java.util.List;

import com.example.bookstoreproject.entity.BookEntity;

public class DataCart {
	private  BookEntity book ;
	private  int count;
	public DataCart(BookEntity book, int count) {
		super();
		this.book = book;
		this.count = count;
	}
	public DataCart () {
		super();
	}
	public BookEntity getBook() {
		return book;
	}
	public void setBook(BookEntity book) {
		this.book = book;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public Double totalPrice() {
		double total = book.getPrice()* count;
		return total;
		
	}
	
	
}
