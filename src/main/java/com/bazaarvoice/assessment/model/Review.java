package com.bazaarvoice.assessment.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/*
   Java object representation of Review Table
 */
@Entity
public class Review {

    @Id
    private Long id;

    @Column( length = 1000000 )
    private String review;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    protected Review() {
    }

    public Review(Long id, String review) {
        this.id  = id;
        this.review = review;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }


    @Override
    public String toString() {
        return String.format("Review [id=%d, review='%s']", id,
                review);
    }

}
