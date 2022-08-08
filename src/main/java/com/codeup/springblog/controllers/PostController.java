package com.codeup.springblog.controllers;


import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private PostRepository postDao;
    private UserRepository userDao;

@GetMapping("/posts")
    public String posts(Model model) {
    List<Post> posts = new ArrayList<>();
    posts.add(new Post(1,"Wow so Amazing!","Today, I learned that I have so much to learn about code! Hooray"));
    posts.add(new Post(2,"I'm learning code","Me too! I'm learning how to code!"));
    posts.add(new Post(3,"Still learning!","I'm still learning how to code!"));
    posts.add(new Post(4,"Knowledge is power","All knowledge is power! Unless you know what you know, you don't know what you don't know!"));

    model.addAttribute("posts", posts);
    return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String post(@PathVariable long id, Model model) {
        Post post = new Post(5,"Wow so Amazing!","Today, I learned that I have so much to learn about code! Hooray");
        model.addAttribute("post", post);
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String viewCreateForm() {
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String savePost(Post post) {
        return "redirect:/posts/" + post.getId();
    }

}




