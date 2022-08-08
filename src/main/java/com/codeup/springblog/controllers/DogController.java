package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Toy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.codeup.springblog.repositories.DogRepository;
import com.codeup.springblog.repositories.ToyRepository;

@Controller
class DogController {

    private DogRepository dogDao;
    private ToyRepository toyDao;

    public DogController(DogRepository dogDao, ToyRepository toyDao) {
        this.dogDao = dogDao;
        this.toyDao = toyDao;
    }

    @GetMapping("/dogs")
    public String showAllDogs(Model model) {
        model.addAttribute("dogs", dogDao.findAll());
        return "dogs/index";
    }

    @GetMapping("/toys/create")
    public String showToyForm(Model model) {
        model.addAttribute("dogs", dogDao.findAll());
        return "toys/create";
    }

    @PostMapping("/toys/create")
    public String createToyForm(@RequestParam(name = "dog") long Id, @RequestParam(name = "name") String name) {
        Toy newToy = new Toy(name);
        newToy.setDog(dogDao.getById(Id));

        toyDao.save(newToy);
        return "redirect:/dogs";
    }
}
