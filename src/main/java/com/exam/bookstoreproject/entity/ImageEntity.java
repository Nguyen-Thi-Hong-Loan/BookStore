package com.exam.bookstoreproject.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "image")
public class ImageEntity extends BaseEntity {

    @Column
    private String link;

    @ManyToOne(cascade = CascadeType.ALL)
    private BookEntity book_id;

    public ImageEntity() {
        super();
    }

    public ImageEntity(String imgLink) {
        super();
        this.link = imgLink;
    }

    public ImageEntity(Long id, Date createDate, String createBy, Date modifyDate, String modifyBy) {
        super(id, createDate, createBy, modifyDate, modifyBy);
    }

    public ImageEntity(Long id, Date createDate, String createBy, Date modifyDate, String modifyBy, String link,
                       BookEntity book_id) {
        super(id, createDate, createBy, modifyDate, modifyBy);
        this.link = link;
        this.book_id = book_id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public BookEntity getBook_id() {
        return book_id;
    }

    public void setBook_id(BookEntity book_id) {
        this.book_id = book_id;
    }

}
