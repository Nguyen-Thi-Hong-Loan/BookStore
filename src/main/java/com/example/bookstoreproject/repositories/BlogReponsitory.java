package com.example.bookstoreproject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bookstoreproject.entity.BlogEntity;


@Repository
public interface BlogReponsitory extends CrudRepository<BlogEntity, Long> {
	
//	// Danh sách nổi bật theo title (sắp xếp theo fee)
//		List<BlogEntity> findByPublisher(@Param("publisher") String title);
	

}

