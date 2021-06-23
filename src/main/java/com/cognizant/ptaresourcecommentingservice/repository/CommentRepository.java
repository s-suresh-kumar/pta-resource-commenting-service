package com.cognizant.ptaresourcecommentingservice.repository;

import com.cognizant.ptaresourcecommentingservice.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
