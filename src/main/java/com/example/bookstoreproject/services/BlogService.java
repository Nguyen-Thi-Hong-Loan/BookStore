package com.example.bookstoreproject.services;

import java.util.List;
import java.util.Optional;

import com.example.bookstoreproject.entity.BlogEntity;

public interface BlogService {

	void deleteAll();

	void deleteAll(List<BlogEntity>  entities);

	void delete(BlogEntity entity);

	void deleteById(Long id);

	long count();

	List<BlogEntity> findAllById(List<Long> ids);

	Iterable<BlogEntity> findAll();

	boolean existsById(Long id);

	Optional<BlogEntity> findById(Long id);

	List<BlogEntity> saveAll(List<BlogEntity>  entities);

	BlogEntity save(BlogEntity entity);

}
