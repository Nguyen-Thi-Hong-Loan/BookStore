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
    
    @Column
    Double price;
    
    @Column
    String author;


    @OneToMany(mappedBy = "book_id", cascade = CascadeType.ALL)
    private List<ImageEntity> image;
    
    @OneToMany(mappedBy = "book_id", cascade = CascadeType.ALL)
    private List<CategoryEntity> category;

    @OneToMany(mappedBy = "book_id")
    private List<FeedbackEntity> feedback;

    @OneToMany(mappedBy = "book_id", cascade = CascadeType.ALL)
    private List<BillDetailEntity> billdetail;
    
	public BookEntity() {
		super();
	}

	public BookEntity(Long id, Date createDate, String createBy, Date modifyDate, String modifyBy, String name,
			String description, Double price, String author, List<ImageEntity> image, List<CategoryEntity> category,
			List<FeedbackEntity> feedback, List<BillDetailEntity> billdetail) {
		super(id, createDate, createBy, modifyDate, modifyBy);
		this.name = name;
		this.description = description;
		this.price = price;
		this.author = author;
		this.image = image;
		this.category = category;
		this.feedback = feedback;
		this.billdetail = billdetail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<ImageEntity> getImage() {
		return image;
	}

	public void setImage(List<ImageEntity> image) {
		this.image = image;
	}

	public List<CategoryEntity> getCategory() {
		return category;
	}

	public void setCategory(List<CategoryEntity> category) {
		this.category = category;
	}

	public List<FeedbackEntity> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<FeedbackEntity> feedback) {
		this.feedback = feedback;
	}

	public List<BillDetailEntity> getBilldetail() {
		return billdetail;
	}

	public void setBilldetail(List<BillDetailEntity> billdetail) {
		this.billdetail = billdetail;
	}

	
	

	

   
  

}
