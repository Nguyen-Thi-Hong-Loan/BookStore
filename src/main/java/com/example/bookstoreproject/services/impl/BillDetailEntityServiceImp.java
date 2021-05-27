package com.example.bookstoreproject.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.bookstoreproject.entity.BillDetailEntity;
import com.example.bookstoreproject.repositories.BillDetailRepository;
import com.example.bookstoreproject.services.BillDetailService;
import com.example.bookstoreproject.services.BillService;

@Service
public class BillDetailEntityServiceImp implements BillDetailService{
	 @Autowired
	    BillDetailRepository billDetailRepository;

	@Override
	public <S extends BillDetailEntity> S save(S entity) {
		return billDetailRepository.save(entity);
	}

	@Override
	public <S extends BillDetailEntity> Optional<S> findOne(Example<S> example) {
		return billDetailRepository.findOne(example);
	}

	@Override
	public Page<BillDetailEntity> findAll(Pageable pageable) {
		return billDetailRepository.findAll(pageable);
	}

	@Override
	public List<BillDetailEntity> findAll() {
		return billDetailRepository.findAll();
	}

	@Override
	public List<BillDetailEntity> findAll(Sort sort) {
		return billDetailRepository.findAll(sort);
	}

	@Override
	public List<BillDetailEntity> findAllById(Iterable<Long> ids) {
		return billDetailRepository.findAllById(ids);
	}

	@Override
	public <S extends BillDetailEntity> List<S> saveAll(Iterable<S> entities) {
		return billDetailRepository.saveAll(entities);
	}

	@Override
	public Optional<BillDetailEntity> findById(Long id) {
		return billDetailRepository.findById(id);
	}

	@Override
	public void flush() {
		billDetailRepository.flush();
	}

	@Override
	public <S extends BillDetailEntity> S saveAndFlush(S entity) {
		return billDetailRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return billDetailRepository.existsById(id);
	}

	@Override
	public void deleteInBatch(Iterable<BillDetailEntity> entities) {
		billDetailRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends BillDetailEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		return billDetailRepository.findAll(example, pageable);
	}

	@Override
	public void deleteAllInBatch() {
		billDetailRepository.deleteAllInBatch();
	}

	@Override
	public BillDetailEntity getOne(Long id) {
		return billDetailRepository.getOne(id);
	}

	@Override
	public <S extends BillDetailEntity> long count(Example<S> example) {
		return billDetailRepository.count(example);
	}

	@Override
	public <S extends BillDetailEntity> boolean exists(Example<S> example) {
		return billDetailRepository.exists(example);
	}

	@Override
	public <S extends BillDetailEntity> List<S> findAll(Example<S> example) {
		return billDetailRepository.findAll(example);
	}

	@Override
	public long count() {
		return billDetailRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		billDetailRepository.deleteById(id);
	}

	@Override
	public <S extends BillDetailEntity> List<S> findAll(Example<S> example, Sort sort) {
		return billDetailRepository.findAll(example, sort);
	}

	@Override
	public void delete(BillDetailEntity entity) {
		billDetailRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends BillDetailEntity> entities) {
		billDetailRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		billDetailRepository.deleteAll();
	}
}
