package com.assignment.EmpowerHer.dao;

import com.assignment.EmpowerHer.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDAO extends JpaRepository<Post,Long> {
}
