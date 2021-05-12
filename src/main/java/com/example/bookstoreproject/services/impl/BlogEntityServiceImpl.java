package com.example.bookstoreproject.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreproject.entity.BlogEntity;
import com.example.bookstoreproject.repositories.BlogReponsitory;
import com.example.bookstoreproject.services.BlogService;

@Service
public class BlogEntityServiceImpl implements BlogService {

	@Autowired
	BlogReponsitory blogReponsitory;

	@Override
	public BlogEntity save(BlogEntity entity) {
		return blogReponsitory.save(entity);
	}

	@Override
	public  List<BlogEntity>  saveAll(List<BlogEntity>  entities) {
		return (List<BlogEntity>) blogReponsitory.saveAll(entities);
	}

	@Override
	public Optional<BlogEntity> findById(Long id) {
		return blogReponsitory.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return blogReponsitory.existsById(id);
	}

	@Override
	public Iterable<BlogEntity> findAll() {
		return blogReponsitory.findAll();
	}

	@Override
	public List<BlogEntity>  findAllById(List<Long> ids) {
		return (List<BlogEntity>) blogReponsitory.findAllById(ids);
	}

	@Override
	public long count() {
		return blogReponsitory.count();
	}

	@Override
	public void deleteById(Long id) {
		blogReponsitory.deleteById(id);
	}

	@Override
	public void delete(BlogEntity entity) {
		blogReponsitory.delete(entity);
	}

	@Override
	public void deleteAll(List<BlogEntity>  entities) {
		blogReponsitory.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		blogReponsitory.deleteAll();
	}
	
}
