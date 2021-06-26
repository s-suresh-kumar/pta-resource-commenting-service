package com.cognizant.ptaresourcecommentingservice.repository;

import com.cognizant.ptaresourcecommentingservice.models.Comment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentRepositoryTest {

    private Comment comment1;
    private Comment comment2;


    @Autowired
    CommentRepository repo;

    @Before
    public void setup() {
        repo.deleteAll();

        Integer resourceId = 1;
        comment1 = new Comment();
        comment1.setComment("First Comment - Comment1 for ResourceId 1");
        comment1.setResourceId(resourceId);

        repo.save(comment1);

        comment2 = new Comment();
        comment2.setComment("Second Comment - Comment1 for ResourceId 1");
        comment2.setResourceId(resourceId);

        repo.save(comment2);

    }

    @Test
    public void shouldReturnAllCommentsByResourceId() {
        // Arrange - happened in setup

        // Act
        List<Comment> result = repo.findCommentByResourceId(1);

        // Assert
        assertEquals(2, result.size());
        assertEquals(comment1, result.get(0));
        assertEquals(comment2, result.get(1));

    }

}