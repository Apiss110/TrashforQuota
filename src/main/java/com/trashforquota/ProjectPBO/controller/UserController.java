package com.trashforquota.ProjectPBO.controller;

import com.trashforquota.ProjectPBO.model.User;
import com.trashforquota.ProjectPBO.repository.UserRepository;
import com.trashforquota.ProjectPBO.repository.RewardRepository;
import com.trashforquota.ProjectPBO.service.RewardService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final RewardRepository rewardRepository;
    private final RewardService rewardService;

    public UserController(UserRepository userRepository, RewardRepository rewardRepository, RewardService rewardService) {
        this.userRepository = userRepository;
        this.rewardRepository = rewardRepository;
        this.rewardService = rewardService;
    }

    @GetMapping("/home")
    public String home(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        model.addAttribute("user", user);
        model.addAttribute("rewards", rewardRepository.findAll());
        return "user/home";
    }

    @PostMapping("/tukar/{rewardId}")
    public String tukarPoin(@AuthenticationPrincipal UserDetails userDetails, 
                            @PathVariable Long rewardId, 
                            RedirectAttributes redirectAttributes) {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();
        String message = rewardService.tukarPoin(user.getId(), rewardId);
        
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/user/home";
    }
}