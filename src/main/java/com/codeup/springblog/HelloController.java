package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello from Spring!";
    }

    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String helloYou(@PathVariable  String name) {
        return String.format("Hello, %s!", name);
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
}