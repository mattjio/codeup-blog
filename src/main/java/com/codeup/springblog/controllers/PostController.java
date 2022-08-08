package com.codeup.springblog.controllers;


import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private PostRepository postDao;
    private UserRepository userDao;
    private final EmailService emailService;

    @Value("${spring.mail.from}")
    private String from;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }




@GetMapping("/posts")
    public String viewAllPosts(Model model) {
    //List<Post> posts = new ArrayList<>();
    //posts.add(new Post(1,"Wow so Amazing!","Today, I learned that I have so much to learn about code! Hooray"));
    //posts.add(new Post(2,"I'm learning code","Me too! I'm learning how to code!"));
    //posts.add(new Post(3,"Still learning!","I'm still learning how to code!"));
    //posts.add(new Post(4,"Knowledge is power","All knowledge is power! Unless you know what you know, you don't know what you don't know!"));

    //model.addAttribute("posts", posts);
    model.addAttribute("posts", postDao.findAll());
    return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable long id, Model model) {
        //Post post = new Post(5,"Wow so Amazing!","Today, I learned that I have so much to learn about code! Hooray");
        //model.addAttribute("post", post);
        model.addAttribute("post", postDao.getById(id));
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String viewCreateForm(Model model) {
        model.addAttribute("title", "Create a New Post");
        model.addAttribute("post", new Post());
        return "/posts/create";
    }

    @GetMapping("/posts/{id}/edit")
    public String viewEditForm(Model model, @PathVariable long id) {
        model.addAttribute("title", "Edit Post");
        model.addAttribute("post", postDao.getById(id));
        return "/posts/create";
    }
    @PostMapping("/posts/create")
    public String savePost(@ModelAttribute Post post) {
        post.setUser(userDao.getById(1L));
        postDao.save(post);
        emailService.prepareAndSend(post, "New Post", "You have a new post!");
        return "redirect:/posts/";
    }

}




