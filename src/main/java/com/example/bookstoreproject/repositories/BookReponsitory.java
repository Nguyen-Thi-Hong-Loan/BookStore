package com.example.bookstoreproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.bookstoreproject.entity.BookEntity;



@Repository
public interface BookReponsitory extends CrudRepository<BookEntity, Long> {
	
	// Danh sách nổi bật theo title (sắp xếp theo fee)
		List<BookEntity> findByPublisher(@Param("publisher") String title);
	

}
