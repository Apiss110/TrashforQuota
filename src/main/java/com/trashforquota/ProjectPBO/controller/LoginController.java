package com.trashforquota.ProjectPBO.controller;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login"; // Mengarah ke src/main/resources/templates/login.html
    }

    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication) {
        // Ngecek role user yang login, lalu arahkan ke halaman yang sesuai
        if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/admin/home";
        }
        return "redirect:/user/home";
    }
}