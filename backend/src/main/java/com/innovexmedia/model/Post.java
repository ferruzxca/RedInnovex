package com.innovexmedia.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.Instant;

@Data
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Lob
    @Column(name = "image_data", nullable = false)
    private byte[] imageData;

    private String imageUrl;

    @Column(columnDefinition = "TEXT")
    private String caption;

    @Column(updatable = false)
    private Instant createdAt = Instant.now();
}
