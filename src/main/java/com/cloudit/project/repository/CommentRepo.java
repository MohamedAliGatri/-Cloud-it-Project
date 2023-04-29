package com.cloudit.project.repository;

import com.cloudit.project.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface CommentRepo extends JpaRepository<Comment,Long> {

    List<Comment> findByAnnouncementId(Long idAnnouncement);
}
