package com.cognizant.ptaresourcecommentingservice.controller;

import com.cognizant.ptaresourcecommentingservice.models.Comment;
import com.cognizant.ptaresourcecommentingservice.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentRepository commentRepo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comment createResource(@RequestBody Comment comment){
        return commentRepo.save(comment);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> getAllComments(){
        return commentRepo.findAll();
    }

    @GetMapping(value="/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Comment getById(@PathVariable Integer id){
        return commentRepo.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void editComments(@RequestBody Comment comment, @PathVariable Integer id){
        if (comment.getId() == null) {
            comment.setId(id);
        }
        if (!comment.getId().equals(id)) {
            throw new IllegalArgumentException("ID in request body: " + comment.getId() + " does not match id in path " + id);
        }
        commentRepo.save(comment);
    }




}
