package com.example.bookstoreproject.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "blog")
public class BlogEntity extends BaseEntity {

    @Column
    String title;

    @Column
    String bookName;

	@Column
	String bookAuthor;
	
	@Column
	String checked;
	
	@Column
	String description;
    @ManyToOne(cascade = CascadeType.ALL)
    private UserEntity userEntity;


    @OneToMany(mappedBy = "blog_id", cascade = CascadeType.ALL)
    private List<ImageBlogEntity> imageBlog;
    

	public BlogEntity() {
		super();
	}

	
	


	public String getChecked() {
		return checked;
	}





	public void setChecked(String checked) {
		this.checked = checked;
	}





	public BlogEntity(Long id, Date createDate, String createBy, Date modifyDate, String modifyBy, String title,
			String bookName, String bookAuthor, String checked, String description, UserEntity userEntity,
			List<ImageBlogEntity> imageBlog) {
		super(id, createDate, createBy, modifyDate, modifyBy);
		this.title = title;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.checked = checked;
		this.description = description;
		this.userEntity = userEntity;
		this.imageBlog = imageBlog;
	}





	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public List<ImageBlogEntity> getImageBlog() {
		return imageBlog;
	}

	public void setImageBlog(List<ImageBlogEntity> imageBlog) {
		this.imageBlog = imageBlog;
	}

	

	
}
