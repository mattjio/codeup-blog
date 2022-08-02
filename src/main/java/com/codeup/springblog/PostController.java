package com.codeup.springblog;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

@GetMapping("/posts")
    @ResponseBody
    public String posts() {
        return "This is the posts page!";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String posts(@PathVariable int id) {
        return String.format("This is the posts page for post %d!", id);
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String create() {
        return "This is the create post page!";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String create(String title, String body) {
        return String.format("This is the create post page!\nTitle: %s\nBody: %s", title, body);
    }

}
