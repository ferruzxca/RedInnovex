package com.innovexmedia.repository;

import com.innovexmedia.model.Follower;
import com.innovexmedia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FollowerRepository extends JpaRepository<Follower, Long> {
    long countByFollowed(User followed);
    Optional<Follower> findByFollowerAndFollowed(User follower, User followed);
}
