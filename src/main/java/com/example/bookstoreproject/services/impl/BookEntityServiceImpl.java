package com.example.bookstoreproject.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;


import com.example.bookstoreproject.entity.BookEntity;
import com.example.bookstoreproject.repositories.BookReponsitory;
import com.example.bookstoreproject.services.BookService;



@Service
public class BookEntityServiceImpl implements BookService {
	
	@Autowired
	BookReponsitory bookReponsitory;
	
	@Override
	public BookEntity save(BookEntity entity) {
		return bookReponsitory.save(entity);
	}

	@Override
	public List<BookEntity> saveAll(List<BookEntity> entities) {
		return (List<BookEntity>) bookReponsitory.saveAll(entities);
	}

	@Override
	public Optional<BookEntity> findById(Long id) {
		return bookReponsitory.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return bookReponsitory.existsById(id);
	}

	@Override
	public Iterable<BookEntity> findAll() {
		return bookReponsitory.findAll();
	}

	@Override
	public List<BookEntity> findAllById(List<Long> ids) {
		return (List<BookEntity>) bookReponsitory.findAllById(ids);
	}

	@Override
	public long count() {
		return bookReponsitory.count();
	}

	@Override
	public void deleteById(Long id) {
		bookReponsitory.deleteById(id);
	}

	@Override
	public void delete(BookEntity entity) {
		bookReponsitory.delete(entity);
	}

	@Override
	public void deleteAll(List<BookEntity> entities) {
		bookReponsitory.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		bookReponsitory.deleteAll();
	}

	@Override
	public List<BookEntity> findByPublisher(String title) {
		return bookReponsitory.findByPublisher(title);
	}
	@Override
	public List<BookEntity> findByAuthor(String author) {
		return bookReponsitory.findByAuthor(author);
	}
	
}
