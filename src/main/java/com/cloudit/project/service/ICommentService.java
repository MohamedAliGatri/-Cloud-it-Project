package com.cloudit.project.service;

import com.cloudit.project.model.Comment;


import java.util.List;

public interface ICommentService {

    void add(Comment comment);
    Comment update(Comment comment);
    List<Comment> getAll();
    Comment getById(long id);
    void remove(long id);
}
