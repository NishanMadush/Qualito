package com.qualito.digiwork.controller;

import com.qualito.digiwork.service.user.LoginAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.format.DateTimeFormatter;

@Controller
public class AdminController {

    @Autowired
    private LoginAttemptService loginAttemptService;

    @GetMapping("/admin/loginAttempts")
    public String loginAttempts(Model model) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Format timestamps before adding them to the model
        model.addAttribute("loginAttempts", loginAttemptService.findAllAttempts().stream()
                .map(attempt -> {
                    attempt.setFormattedTimestamp(attempt.getTimestamp().format(formatter));
                    return attempt;
                })
                .toList());

        return "admin/loginAttempts";  
    }
}
