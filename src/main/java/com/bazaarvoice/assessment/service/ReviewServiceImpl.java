package com.bazaarvoice.assessment.service;

import com.bazaarvoice.assessment.dao.ReviewRepository;
import com.bazaarvoice.assessment.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by teje0687 on 8/11/19.
 */
@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> findByReviewIgnoreCaseContaining(String review) {
        return reviewRepository.findByReviewIgnoreCaseContaining(review);
    }
}
