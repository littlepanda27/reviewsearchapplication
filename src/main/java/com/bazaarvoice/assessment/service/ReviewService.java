package com.bazaarvoice.assessment.service;

import com.bazaarvoice.assessment.model.Review;

import java.util.List;

/**
 * Created by teje0687 on 8/11/19.
 */
public interface ReviewService {

    public List<Review> getAllReviews();
    List<Review> findByReviewIgnoreCaseContaining(String review);

}
