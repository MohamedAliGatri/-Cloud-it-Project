package com.programming.techie.clouditMalek.repository;

import com.programming.techie.clouditMalek.model.Post;
import com.programming.techie.clouditMalek.model.User;
import com.programming.techie.clouditMalek.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}
