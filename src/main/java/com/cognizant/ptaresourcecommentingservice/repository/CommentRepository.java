package com.cognizant.ptaresourcecommentingservice.repository;

import com.cognizant.ptaresourcecommentingservice.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    public List<Comment> findCommentByResourceId(Integer id);
}
