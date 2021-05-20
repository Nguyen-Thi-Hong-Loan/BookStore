package com.example.bookstoreproject.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreproject.entity.BillEntity;
import com.example.bookstoreproject.repositories.BillReponsitory;
import com.example.bookstoreproject.services.BillService;

@Service
public class BillEntityServiceImpl implements BillService{

	@Autowired
	BillReponsitory billreponsitory;

	@Override
	public  BillEntity save(BillEntity entity) {
		return billreponsitory.save(entity);
	}

	@Override
	public List<BillEntity> saveAll(List<BillEntity> entities) {
		return (List<BillEntity>) billreponsitory.saveAll(entities);
	}

	@Override
	public Optional<BillEntity> findById(Long id) {
		return billreponsitory.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return billreponsitory.existsById(id);
	}

	@Override
	public Iterable<BillEntity> findAll() {
		return billreponsitory.findAll();
	}

	@Override
	public List<BillEntity> findAllById(List<Long> ids) {
		return (List<BillEntity>) billreponsitory.findAllById(ids);
	}

	@Override
	public long count() {
		return billreponsitory.count();
	}

	@Override
	public void deleteById(Long id) {
		billreponsitory.deleteById(id);
	}

	@Override
	public void delete(BillEntity entity) {
		billreponsitory.delete(entity);
	}

	@Override
	public void deleteAll(List<BillEntity> entities) {
		billreponsitory.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		billreponsitory.deleteAll();
	}
	
}
