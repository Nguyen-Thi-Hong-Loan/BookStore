package com.example.bookstoreproject.globalData;

import java.util.ArrayList;
import java.util.List;

import com.example.bookstoreproject.entity.BookEntity;

public class GlobalData {

	public static List<BookEntity> cart ;
		static {
			cart = new ArrayList<BookEntity>();
		}
		
	
}
