package com.example.bookstoreproject.services;

import java.util.List;
import java.util.Optional;


import com.example.bookstoreproject.entity.BookEntity;
import com.example.bookstoreproject.repositories.BookReponsitory;

public interface BookService {

	void deleteAll();

	void deleteAll(List<BookEntity> entities);

	void delete(BookEntity entity);

	void deleteById(Long id);

	long count();

	List<BookEntity> findAllById(List<Long> ids);

	Iterable<BookEntity> findAll();

	boolean existsById(Long id);

	Optional<BookEntity> findById(Long id);

	List<BookEntity> saveAll(List<BookEntity> entities);

	BookEntity save(BookEntity entity);

	

}
