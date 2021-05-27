package com.example.bookstoreproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.bookstoreproject.entity.BillDetailEntity;
@Service
public interface BillDetailService {

	void deleteAll();

	void deleteAll(Iterable<? extends BillDetailEntity> entities);

	void delete(BillDetailEntity entity);

	<S extends BillDetailEntity> List<S> findAll(Example<S> example, Sort sort);

	void deleteById(Long id);

	long count();

	<S extends BillDetailEntity> List<S> findAll(Example<S> example);

	<S extends BillDetailEntity> boolean exists(Example<S> example);

	<S extends BillDetailEntity> long count(Example<S> example);

	BillDetailEntity getOne(Long id);

	void deleteAllInBatch();

	<S extends BillDetailEntity> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<BillDetailEntity> entities);

	boolean existsById(Long id);

	<S extends BillDetailEntity> S saveAndFlush(S entity);

	void flush();

	Optional<BillDetailEntity> findById(Long id);

	<S extends BillDetailEntity> List<S> saveAll(Iterable<S> entities);

	List<BillDetailEntity> findAllById(Iterable<Long> ids);

	List<BillDetailEntity> findAll(Sort sort);

	List<BillDetailEntity> findAll();

	Page<BillDetailEntity> findAll(Pageable pageable);

	<S extends BillDetailEntity> Optional<S> findOne(Example<S> example);

	<S extends BillDetailEntity> S save(S entity);

}
