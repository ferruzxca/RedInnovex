package com.innovexmedia.service;

import com.innovexmedia.model.Post;
import com.innovexmedia.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostService {
    Post createPost(User user, MultipartFile image, String caption);
    List<Post> getFeed();
    List<Post> getPostsByUser(User user);
}
