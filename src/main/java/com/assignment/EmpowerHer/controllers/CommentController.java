package com.assignment.EmpowerHer.controllers;

import com.assignment.EmpowerHer.models.Comment;
import com.assignment.EmpowerHer.security.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/posts/{id}/addComment")
    public ResponseEntity<String> addComment(@RequestBody Comment comment, @PathVariable Long id){
        Comment response= commentService.addComment(comment,id);
        return new ResponseEntity<>("Comment created successfully"+response.getId(), HttpStatus.CREATED);
    }


    @GetMapping("/comments/{id}")
    public  ResponseEntity<Comment> getCommentByCommentId(@PathVariable Long id){
        Comment response= commentService.getCommentByCommentId(id);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/post/{id}/comments")
    public ResponseEntity<List<Comment>> getCommentByPostId(@PathVariable Long id){
        List<Comment> response= commentService.getCommentByPostId(id);
        return ResponseEntity.ok(response);
    }


    @PutMapping("/post/{postId}/comment/{commentId}")
    public ResponseEntity<String> updateCommentByCommentId(@PathVariable Long commentId,@PathVariable Long postId, @RequestBody Comment comment){
        commentService.updateCommentByCommentId(commentId,postId,comment);
        return new ResponseEntity<>("Comment updated successfully", HttpStatus.OK);
    }


    @DeleteMapping("/comments/{id}")
    public ResponseEntity<String> deleteCommentByCommentId(@PathVariable Long id){
        commentService.deleteCommentByCommentId(id);
        return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
    }
}
