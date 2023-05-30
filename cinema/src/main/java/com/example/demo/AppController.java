package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @Autowired
    private SessionService service;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Sesion> listSessions = service.listAll(keyword);
        model.addAttribute("listSessions", listSessions);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewSessionForm(Model model) {
        Sesion session = new Sesion();
        model.addAttribute("session", session);
        return "new_session";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveSession(@ModelAttribute("session") Sesion session) {
        service.save(session);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditSessionForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_session");
        Sesion session = service.get(id);
        mav.addObject("session", session);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteSession(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}

