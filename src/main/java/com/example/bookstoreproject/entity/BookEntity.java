package com.example.bookstoreproject.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
	@Column
	String publisher;
	@Column
	int publishYear;
	@Column
	int qualityPage;
	@Column
	String supplier;
	@Column
	String checked;

	@OneToMany(mappedBy = "book_id", cascade = CascadeType.ALL)
	private List<ImageEntity> image;

	@OneToMany(mappedBy = "book_id", cascade = CascadeType.ALL)
	private List<CategoryEntity> category;

	@OneToMany(mappedBy = "book_id")
	private List<FeedbackEntity> feedback;

	@OneToMany(mappedBy = "book_id", cascade = CascadeType.ALL)
	private List<BillDetailEntity> billDetail;

	public BookEntity() {
		super();
	}

	public BookEntity(Long id, Date createDate, String createBy, Date modifyDate, String modifyBy, String name,
			String description, Double price, String author, String publisher, int publishYear, int qualityPage,
			String supplier, String checked, List<ImageEntity> image, List<CategoryEntity> category,
			List<FeedbackEntity> feedback, List<BillDetailEntity> billDetail) {
		super(id, createDate, createBy, modifyDate, modifyBy);
		this.name = name;
		this.description = description;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
		this.publishYear = publishYear;
		this.qualityPage = qualityPage;
		this.supplier = supplier;
		this.checked = checked;
		this.image = image;
		this.category = category;
		this.feedback = feedback;
		this.billDetail = billDetail;
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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public int getQualityPage() {
		return qualityPage;
	}

	public void setQualityPage(int qualityPage) {
		this.qualityPage = qualityPage;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
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

	public List<BillDetailEntity> getBillDetail() {
		return billDetail;
	}

	public void setBillDetail(List<BillDetailEntity> billDetail) {
		this.billDetail = billDetail;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

}
