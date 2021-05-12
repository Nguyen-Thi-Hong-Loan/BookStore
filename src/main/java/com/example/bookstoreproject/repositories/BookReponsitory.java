package com.example.bookstoreproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstoreproject.entity.BookEntity;



@Repository
public interface BookReponsitory extends CrudRepository<BookEntity, Long> {
	
	

}
