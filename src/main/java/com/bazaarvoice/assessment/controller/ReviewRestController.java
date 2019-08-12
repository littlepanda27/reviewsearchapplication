package com.bazaarvoice.assessment.controller;

import com.bazaarvoice.assessment.model.Review;
import com.bazaarvoice.assessment.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by teje0687 on 8/11/19.
 */
@RestController
public class ReviewRestController {
    @Autowired
    ReviewService reviewService;

    @RequestMapping(path="/reviews", method= RequestMethod.GET)
    public List<Review> getAllReviews(){
        return reviewService.getAllReviews();
    }
    @RequestMapping(value = "/reviews/{str}", method = RequestMethod.GET)
    public List<Review> findByReviewIgnoreCaseContaining(@PathVariable("review") String str){
        return reviewService.findByReviewIgnoreCaseContaining(str);
    }
}
