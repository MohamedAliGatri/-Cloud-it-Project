package com.cloudit.project.dto;

import com.cloudit.project.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.xml.stream.events.Comment;
import java.util.Set;

@Getter
@Setter
public class PostDto {

    private Long id;
    private String content;
    private String title;
    private String userName;
    private String image;
    private User user;
    private Set<Comment> comments;
    private String created_at;
    private String updated_at;




}
