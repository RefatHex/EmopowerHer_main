package com.assignment.EmpowerHer.controllers;

import com.assignment.EmpowerHer.security.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.assignment.EmpowerHer.models.Post;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<String> createPost(@RequestBody Post post){
        Post response =postService.createPost(post);
        return new ResponseEntity<>("Post created successfully"+response.getId(), HttpStatus.CREATED);
    }
    @GetMapping("/getPost/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id){
       Post response =postService.getPostById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAllPosts")
    public List<Post> getAllPosts(){
       return postService.getAllPost();
    }

    @PutMapping("/updatePost/{id}")
    public ResponseEntity<String> updatePostById(@PathVariable Long id, @RequestBody Post post){
        postService.updatePostById(id, post);
        return new ResponseEntity<>("Post updated successfully", HttpStatus.OK);
    }
    @DeleteMapping("/deletePost/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable Long id){
        postService.deletePostById(id);
        return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
    }
}
