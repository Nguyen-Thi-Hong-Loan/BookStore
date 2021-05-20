package com.example.bookstoreproject.services;

import java.util.List;
import java.util.Optional;

import com.example.bookstoreproject.entity.BillEntity;

public interface BillService {

	void deleteAll();

	void deleteAll(List<BillEntity> entities);

	void delete(BillEntity entity);

	void deleteById(Long id);

	long count();

	List<BillEntity> findAllById(List<Long> ids);

	Iterable<BillEntity> findAll();

	boolean existsById(Long id);

	Optional<BillEntity> findById(Long id);

	List<BillEntity> saveAll(List<BillEntity> entities);

	BillEntity save(BillEntity entity);

}
