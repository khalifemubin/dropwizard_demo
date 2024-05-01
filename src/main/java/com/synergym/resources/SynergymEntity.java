package com.synergym.resources;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // name of table to be used in the code
@Table(name = "book_reviews") // name of table in database
public class SynergymEntity {

    // @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private String id;

    @Column(name = "book_id")
    private String bookId;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "review")
    private String review;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

}
