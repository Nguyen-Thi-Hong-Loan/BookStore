package com.example.bookstoreproject.globalData;

import java.util.ArrayList;
import java.util.List;

import com.example.bookstoreproject.entity.BookEntity;

public class GlobalDataCart {

	public static List<BookEntity> cart ;
	public static List<DataCart> dataCarts;
		static {
			cart = new ArrayList<BookEntity>();
			dataCarts = new ArrayList<DataCart>();
		}
		
	
}
