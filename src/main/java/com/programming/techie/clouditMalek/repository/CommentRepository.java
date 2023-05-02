package com.programming.techie.clouditMalek.repository;

import com.programming.techie.clouditMalek.model.Comment;
import com.programming.techie.clouditMalek.model.Post;
import com.programming.techie.clouditMalek.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);
}
