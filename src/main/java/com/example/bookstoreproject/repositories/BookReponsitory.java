package com.example.bookstoreproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.bookstoreproject.entity.BookEntity;

@Repository
public interface BookReponsitory extends CrudRepository<BookEntity, Long> {

	// Danh sách theo tên nhà xuất bản
	List<BookEntity> findByPublisher(@Param("publisher") String title);

	// Danh sách theo tên tác giả
	List<BookEntity> findByAuthor(@Param("author") String author);
	
	// Danh sách trong cart
	List<BookEntity> findByIdIn(List<Long> ids);
	
	
}
