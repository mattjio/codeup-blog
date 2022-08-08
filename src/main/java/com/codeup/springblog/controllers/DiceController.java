package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DiceController {

    @GetMapping("/dice-roll")
    public String diceRoll() {
        return "dice";
    }

   // roll a random number between 1 and 6 and check if it matches the number in the url
    @GetMapping("/dice-roll/{num}")
    @ResponseBody
    public String diceRoll(@PathVariable int num) {
        int roll = (int) (Math.random() * 6) + 1;
        String result = String.format("You rolled a %d!", roll);
        if (roll == num) {
            result += " It's a match!";
        }
        return result;
    }


    //@GetMapping("/dice-roll/{num}")
    //@ResponseBody
    //public String diceRoll(@PathVariable int num) {
    //    return "You rolled a " + (int) (Math.random() * num + 1);
    //}

}
