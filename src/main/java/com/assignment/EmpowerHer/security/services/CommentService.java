package com.assignment.EmpowerHer.security.services;

import com.assignment.EmpowerHer.models.Comment;
import com.assignment.EmpowerHer.models.Post;
import com.assignment.EmpowerHer.dao.CommentDao;
import com.assignment.EmpowerHer.dao.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private PostDAO postDAO;

    @Autowired
    private CommentDao commentDAO;

    // addComment()
     public Comment addComment(Comment comment,Long postId) {
        Post post=postDAO.findById(postId).orElseThrow(()-> new RuntimeException(postId + " not found"));
        comment.setPost(post);

        return commentDAO.save(comment);
    }

    public Comment getCommentByCommentId(Long id){
         return commentDAO.findById(id).orElseThrow(()-> new RuntimeException(id + " not found"));
    }


    public List<Comment> getCommentByPostId(Long id){
        return commentDAO.findByPostId(id);
    }




    public void updateCommentByCommentId(Long commentId,Long postId,Comment comment){
        Post post=postDAO.findById(postId).orElseThrow(()-> new RuntimeException(postId + " not found"));
        comment.setId(commentId);
        comment.setPost(post);
        commentDAO.save(comment);
    }

    public void deleteCommentByCommentId(Long id){
        if(commentDAO.findById(id).isPresent()){
            commentDAO.deleteById(id);
        }else{
            throw  new RuntimeException(id + " not found");
        }
    }



}
