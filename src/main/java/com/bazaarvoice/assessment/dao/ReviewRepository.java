package com.bazaarvoice.assessment.dao;


import com.bazaarvoice.assessment.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
Finder method to retrieve filtered data from H2 database
 */
@Repository("reviewRepository")
public interface ReviewRepository extends JpaRepository<Review, Long> {

	@Query
	List<Review> findByReviewIgnoreCaseContaining(String review);
}
