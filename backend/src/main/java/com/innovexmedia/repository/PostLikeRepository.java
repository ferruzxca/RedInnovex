package com.innovexmedia.repository;

import com.innovexmedia.model.PostLike;
import com.innovexmedia.model.Post;
import com.innovexmedia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    long countByPost(Post post);
    Optional<PostLike> findByPostAndUser(Post post, User user);
}
