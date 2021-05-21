package com.example.bookstoreproject.globalData;

import java.util.ArrayList;
import java.util.List;

import com.example.bookstoreproject.entity.BookEntity;

public class GlobalDataCart {

	public static List<BookEntity> cart ;
	public static List<DataCart> datacart;
		static {
			cart = new ArrayList<BookEntity>();
			datacart = new ArrayList<DataCart>();
		}
		
	
}
