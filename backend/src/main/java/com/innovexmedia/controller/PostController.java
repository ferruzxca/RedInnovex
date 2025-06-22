package com.innovexmedia.controller;

import com.innovexmedia.model.Post;
import com.innovexmedia.model.User;
import com.innovexmedia.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<Post> create(@AuthenticationPrincipal UserDetails userDetails,
                                       @RequestParam("image") MultipartFile image,
                                       @RequestParam("caption") String caption) {
        // TODO fetch user from userDetails
        User user = new User();
        user.setId(1L); // placeholder
        return ResponseEntity.ok(postService.createPost(user, image, caption));
    }

    @GetMapping("/feed")
    public ResponseEntity<List<Post>> feed() {
        return ResponseEntity.ok(postService.getFeed());
    }
}
