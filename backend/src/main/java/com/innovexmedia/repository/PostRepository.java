package com.innovexmedia.repository;

import com.innovexmedia.model.Post;
import com.innovexmedia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByCreatedAtDesc();
    List<Post> findByUserOrderByCreatedAtDesc(User user);
}
