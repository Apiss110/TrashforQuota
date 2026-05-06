package com.trashforquota.ProjectPBO.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TukarController {

    @GetMapping("/tukar")
    public String tukarPage(Model model) {

        // contoh data user (sementara)
        model.addAttribute("noHp", "08123456789");

        return "tukar"; // harus cocok dengan templates/tukar.html
    }
}