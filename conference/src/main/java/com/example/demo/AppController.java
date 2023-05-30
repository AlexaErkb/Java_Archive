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
    private ConferenceService service;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Conference> listConferences = service.listAll(keyword);
        // вот это меняем
        model.addAttribute("listConferences", listConferences);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewConferenceForm(Model model) {
        Conference conference = new Conference();
        model.addAttribute("conference", conference);
        return "new_conference";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveConference(@ModelAttribute("conference") Conference conference) {
        service.save(conference);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditConferenceForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_conference");
        Conference conference = service.get(id);
        mav.addObject("conference", conference);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteConference(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}

