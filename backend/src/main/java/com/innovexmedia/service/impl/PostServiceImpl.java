package com.innovexmedia.service.impl;

import com.innovexmedia.model.Post;
import com.innovexmedia.model.User;
import com.innovexmedia.repository.PostRepository;
import com.innovexmedia.service.PostService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post createPost(User user, MultipartFile image, String caption) {
        try {
            Post post = new Post();
            post.setUser(user);
            post.setCaption(caption);
            post.setImageData(image.getBytes());
            return postRepository.save(post);
        } catch (IOException e) {
            throw new RuntimeException("Could not store image", e);
        }
    }

    @Override
    public List<Post> getFeed() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }

    @Override
    public List<Post> getPostsByUser(User user) {
        return postRepository.findByUserOrderByCreatedAtDesc(user);
    }
}
