package com.trashforquota.ProjectPBO.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    // Menampilkan halaman login (Gantiin fungsi LoginController)
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Logika setelah login sukses untuk menentukan arah (Admin/User)
    @GetMapping("/dashboard")
    public String dashboard(Authentication auth) {
        if (auth == null) return "redirect:/login";

        // Cek role dari Spring Security
        boolean isAdmin = auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

        if (isAdmin) {
            return "redirect:/admin/home";
        }
        return "redirect:/user/home";
    }

    // Halaman index/landing page (opsional)
    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }
}