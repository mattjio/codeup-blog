package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddInfoController {

    @GetMapping("/new-info")
    public String newInfoForm() {
        return "new-info";
    }

    @PostMapping("/new-info")
    public String newInfoSubmit(@RequestParam(name = "info") String info, Model model) {
        model.addAttribute("info", info);
        return "new-info";
    }

}
