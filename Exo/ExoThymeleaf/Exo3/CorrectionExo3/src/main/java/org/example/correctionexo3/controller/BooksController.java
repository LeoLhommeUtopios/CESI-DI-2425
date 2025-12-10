package org.example.correctionexo3.controller;

import org.example.correctionexo3.entity.Books;
import org.example.correctionexo3.entity.Genre;
import org.example.correctionexo3.service.BooksService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Book;
import java.util.UUID;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BooksService service;


    public BooksController(BooksService service) {

        this.service = service;
    }

    @GetMapping
    public String  bookList(Model model){
        model.addAttribute("books",service.get());
        return "/books/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model,@PathVariable UUID id){
        model.addAttribute("book",service.get(id));
        return "/books/view";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/add")
    public String formBook (Model model){
        model.addAttribute("book",new Books());
        model.addAttribute("genre", Genre.values());
        return "/books/form";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public String addBooks (Books books){
        service.create(books);
        return "redirect:/books";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/edit/{id}")
    public String editBook (Model model, @PathVariable UUID id){
        model.addAttribute("book",service.get(id));
        model.addAttribute("genre", Genre.values());
        return "/books/form";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/edit")
    public String edit (Books book){
        service.edit(book);
        return "redirect:/books";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable UUID id){
        service.delete(id);
        return "redirect:/books";
    }
}
