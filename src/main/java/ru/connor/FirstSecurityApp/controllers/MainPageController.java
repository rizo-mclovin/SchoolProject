package ru.connor.FirstSecurityApp.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@RequiredArgsConstructor
@Controller
public class MainPageController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/choiceBooksOrStudents")
    public String showChoice() {
        return "main/choice";
    }



//    @GetMapping("/books")
//    public String showAllBooks() {
//        return "main/books";
//    }


}