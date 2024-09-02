package com.assignment.EmpowerHer.security.services;

import com.assignment.EmpowerHer.models.Post;
import com.assignment.EmpowerHer.dao.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostDAO postDAO;

    public Post createPost(Post post) {
         return postDAO.save(post);
    }
    public Post getPostById(Long id) {
        return postDAO.findById(id).orElseThrow(()-> new RuntimeException(id + " not found"));
    }
    public List<Post> getAllPost(){
        return postDAO.findAll();
    }
    public void updatePostById(Long id, Post post) {
        if(postDAO.findById(id).isPresent()){
            Post newPost=new Post();
            newPost.setId(id);
            newPost.setTopic(post.getTopic());
            newPost.setTitle(post.getTitle());
            newPost.setDescription(post.getDescription());

            postDAO.save(newPost);
        }else{
            throw  new RuntimeException(id + " not found");
        }
    }
    public void deletePostById(Long id){
        if(postDAO.findById(id).isPresent()){
            postDAO.deleteById(id);
        }else{
            throw  new RuntimeException(id + " not found");
        }
    }
}
