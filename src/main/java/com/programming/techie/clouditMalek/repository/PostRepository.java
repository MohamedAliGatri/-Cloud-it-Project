package com.programming.techie.clouditMalek.repository;

import com.programming.techie.clouditMalek.model.Post;
import com.programming.techie.clouditMalek.model.Subreddit;
import com.programming.techie.clouditMalek.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllBySubreddit(Subreddit subreddit);

    List<Post> findByUser(User user);
}
