package com.trashforquota.ProjectPBO.controller;

import com.trashforquota.ProjectPBO.repository.SmartBinRepository;
import com.trashforquota.ProjectPBO.repository.TransaksiRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final SmartBinRepository smartBinRepository;
    private final TransaksiRepository transaksiRepository;

    public AdminController(SmartBinRepository smartBinRepository, TransaksiRepository transaksiRepository) {
        this.smartBinRepository = smartBinRepository;
        this.transaksiRepository = transaksiRepository;
    }

    @GetMapping("/home")
    public String adminHome(Model model) {
        model.addAttribute("bins", smartBinRepository.findAll());
        model.addAttribute("recentTransactions", transaksiRepository.findAll());
        return "admin/dashboard";
    }
}