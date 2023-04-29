package com.cloudit.project.controller;

import com.cloudit.project.model.Comment;
import com.cloudit.project.repository.CommentRepo;
import com.cloudit.project.service.ICommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("/Comment")
public class CommentController {

    private ICommentService iCommentService;

    @PostMapping("/add")
    public void add(@RequestBody Comment comment) {iCommentService.add(comment);}

    @PutMapping("/update")
    public Comment update(@RequestBody Comment comment) {
        return iCommentService.update(comment);
    }

    @GetMapping("/all")
    public List<Comment> getAll() {
        return iCommentService.getAll();
    }

    @GetMapping("/get/{id}")
    public Comment getById(@PathVariable long id) {
        return iCommentService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void remove(@PathVariable long id) {
        iCommentService.remove(id);
    }





    private final CommentRepo commentRepo;
    @PostMapping("/{commentId}/like")
    public ResponseEntity<String> likeComment(@PathVariable Long commentId) {
        Optional<Comment> optionalComment = commentRepo.findById(commentId);
        if (optionalComment.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Comment comment = optionalComment.get();
        comment.setLikes(comment.getLikes() + 1);
        commentRepo.save(comment);

        return ResponseEntity.ok("Announcement liked successfully.");
    }

    @PostMapping("/{commentId}/dislike")
    public ResponseEntity<String> dislikeAnnouncement(@PathVariable Long commentId) {
        Optional<Comment> optionalComment = commentRepo.findById(commentId);
        if (optionalComment.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Comment comment = optionalComment.get();
        comment.setDislikes(comment.getDislikes() + 1);
        commentRepo.save(comment);

        return ResponseEntity.ok("Announcement disliked successfully.");
    }
}
