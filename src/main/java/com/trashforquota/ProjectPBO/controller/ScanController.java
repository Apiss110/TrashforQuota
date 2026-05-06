package com.trashforquota.ProjectPBO.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class ScanController {

    @GetMapping("/scan")
    public String scanPage() {
        return "scan"; // arah ke templates/user/scan.html
    }
    @PostMapping("/scan")
    public String processScan(
        @RequestParam int organik,
        @RequestParam int anorganik,
        @RequestParam int b3,
        Model model
) {
    int poin = (organik * 1) + (anorganik * 2) + (b3 * 3);

    model.addAttribute("hasilPoin", poin);

    return "/scan";
}
}
