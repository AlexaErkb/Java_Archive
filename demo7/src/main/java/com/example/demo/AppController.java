package com.example.demo;

import java.io.IOException;
import java.util.List;

import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @Autowired
    private BookService service;
    @Autowired
    private PeopleService service2;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword, @Param("keyword") String keyword2) {
        List<Book> listBooks = service.listAll(keyword);
        model.addAttribute("listBooks", listBooks);
        model.addAttribute("keyword", keyword);
        List<People> listPeople = service2.listAll(keyword2);
        model.addAttribute("listPeople", listPeople);
        model.addAttribute("keyword", keyword2);
        return "login";
    }

    @RequestMapping("/admin")
    public String viewAdmin(Model model, @Param("keyword") String keyword, @Param("keyword") String keyword2) {
        List<Book> listBooks = service.listAll(keyword);
        model.addAttribute("listBooks", listBooks);
        model.addAttribute("keyword", keyword);
        List<People> listPeople = service2.listAll(keyword2);
        model.addAttribute("listPeople", listPeople);
        model.addAttribute("keyword", keyword2);
        return "index";
    }

    @RequestMapping("/user")
    public String viewUser(Model model, @Param("keyword") String keyword, @Param("keyword") String keyword2) {
        List<Book> listBooks = service.listAll(keyword);
        model.addAttribute("listBooks", listBooks);
        model.addAttribute("keyword", keyword);
        List<People> listPeople = service2.listAll(keyword2);
        model.addAttribute("listPeople", listPeople);
        model.addAttribute("keyword", keyword2);
        return "index_user";
    }

    @RequestMapping("/new")
    public String showNewBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "ff";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute("book") Book book) {
        service.save(book);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditBookForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_book");
        Book book = service.get(id);
        mav.addObject("book", book);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}

