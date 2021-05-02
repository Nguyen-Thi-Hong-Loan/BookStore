package com.example.bookstoreproject.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class BookEntity extends BaseEntity {

    @Column
    String name;

    @Column
    String description;

    @ManyToOne(cascade = CascadeType.ALL)
    private UserEntity userEntity;


    @OneToMany(mappedBy = "book_id", cascade = CascadeType.ALL)
    private List<ImageEntity> image;

    @OneToMany(mappedBy = "book_id")
    private List<FeedbackEntity> feedback;

    @OneToMany(mappedBy = "bookEntity")
    private List<BillEntity> bill;

    
	public BookEntity() {
		super();
	}


	public BookEntity(Long id, Date createDate, String createBy, Date modifyDate, String modifyBy, String name,
			String description, UserEntity userEntity, List<ImageEntity> image, List<FeedbackEntity> feedback,
			List<BillEntity> bill) {
		super(id, createDate, createBy, modifyDate, modifyBy);
		this.name = name;
		this.description = description;
		this.userEntity = userEntity;
		this.image = image;
		this.feedback = feedback;
		this.bill = bill;
	}

   
  

}
