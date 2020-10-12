package com.example.bootpreparation.controller;

import com.example.bootpreparation.service.AdService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personal-area")
public class PersonalArea {

    private final AdService adService;

    public PersonalArea(AdService adService) {
        this.adService = adService;
    }

    @GetMapping()
    public String adAllGet(Model model) {
        model.addAttribute("advertisements", adService.findAllAdThisUser());
        return "personalArea";
    }
}
