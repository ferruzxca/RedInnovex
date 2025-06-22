package com.innovexmedia.repository;

import com.innovexmedia.model.CommentLike;
import com.innovexmedia.model.Comment;
import com.innovexmedia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentLikeRepository extends JpaRepository<CommentLike, Long> {
    long countByComment(Comment comment);
    Optional<CommentLike> findByCommentAndUser(Comment comment, User user);
}
