package com.example.bookstoreproject.services.impl;

import com.example.bookstoreproject.entity.BillDetailEntity;
import com.example.bookstoreproject.entity.BillEntity;
import com.example.bookstoreproject.entity.BookEntity;
import com.example.bookstoreproject.entity.UserEntity;
import com.example.bookstoreproject.globalData.DataCart;
import com.example.bookstoreproject.repositories.BillRepository;
import com.example.bookstoreproject.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BillEntityServiceImpl implements BillService {
    @Autowired
    BillRepository billRepository;



    @Override
    public BillEntity save(BillEntity billEntity) {
        System.out.println("ENTITYYYYYY  " + billEntity.getUserEntity().getName());


        return billRepository.save(billEntity);
    }
//
//    @Override
//    public BillEntity saveBill(UserEntity userEntity, List<DataCart> carts) {
//

//        BillEntity billEntity;
//        for (int i = 0; i < carts.size(); i++) {
//            BookEntity bookEntity = carts.get(i).getBook();
//            System.out.println("IDDDDDDDDDDDD   " + bookEntity.getId());
//
//            BillDetailEntity billDetailEntity = new BillDetailEntity();
//            billDetailEntity.setPrice(bookEntity.getPrice());
//            billDetailEntity.setQuality(carts.get(i).getCount());
//            billDetailEntity.setBook_id(bookEntity);
//            billDetailEntity.setCreateDate(new Date());
//
//
//            System.out.println("BILLLLL DETAILLL   " + billDetailEntity.getBook_id());
//
//            billEntity = new BillEntity();
////            billEntity.setTotalMoney(totalPrice);
////            billEntity.setBillDetail(billDetailEntity);
//            billEntity.setUserEntity(userEntity);
//            billEntity.setCreateDate(new Date());
//
//            System.out.println("BILLLLL   " + billEntity.getTotalMoney());
//
//            billRepository.save(billEntity);
//        }
//
//
//        return null;
//    }

    @Override
    public List<BillEntity> saveAll(List<BillEntity> entities) {
        return (List<BillEntity>) billRepository.saveAll(entities);
    }

    @Override
    public Optional<BillEntity> findById(Long id) {
        return billRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return billRepository.existsById(id);
    }

    @Override
    public Iterable<BillEntity> findAll() {
        return billRepository.findAll();
    }

    @Override
    public List<BillEntity> findAllById(List<Long> ids) {
        return (List<BillEntity>) billRepository.findAllById(ids);
    }

    @Override
    public long count() {
        return billRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        billRepository.deleteById(id);
    }

    @Override
    public void delete(BillEntity entity) {
        billRepository.delete(entity);
    }

    @Override
    public void deleteAll(List<BillEntity> entities) {
        billRepository.deleteAll(entities);
    }

    @Override
    public BillEntity findByUserEntityAndPrice(UserEntity userEntity, double totalPrice) {
        return billRepository.findByUserEntityAndTotalMoney(userEntity, totalPrice).orElse(null);
    }

    @Override
    public void deleteAll() {
        billRepository.deleteAll();
    }

}
