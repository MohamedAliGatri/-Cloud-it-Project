package com.cloudit.project.serviceImpl;

import com.cloudit.project.model.Comment;
import com.cloudit.project.repository.CommentRepo;
import com.cloudit.project.service.ICommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CommentServiceImpl implements ICommentService{
    CommentRepo commentRepo;
    @Override
    public void add(Comment comment) {
        commentRepo.save(comment);

    }

    @Override
    public Comment update(Comment comment) {
        return commentRepo.save(comment);
    }

    @Override
    public List<Comment> getAll() {
        return commentRepo.findAll() ;
    }

    @Override
    public Comment getById(long id) {
        return commentRepo.findById(id).orElse(null);
    }

    @Override
    public void remove(long id) {
        commentRepo.deleteById(id);

    }

}
