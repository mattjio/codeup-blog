package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
class HelloController {

   // @GetMapping("/hello")
    //@ResponseBody
    //public String hello() {
      //  return "Hello from Spring!";
   // }

    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET)

    public String helloYou(@PathVariable  String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/number/{num}")
    @ResponseBody
    public String reportNumber(@PathVariable int num) {
        String intro = String.format("Here are some truths of the number %d", num);
        String isEven = String.format("%d is %s", num, num % 2 == 0 ? "even" : "odd");
        String numSquared = String.format("%d squared is %d", num, num * num);
        String fizzBuzz = String.format("%d is %s", num, num % 3 == 0 && num % 5 == 0 ? "fizzbuzz" : "not fizzbuzz");
        return String.join("\n", intro, isEven, numSquared, fizzBuzz);
    }

    @GetMapping("/join")
    public String showJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "join";
    }
}