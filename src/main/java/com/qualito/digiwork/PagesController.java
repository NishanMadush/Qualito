package com.qualito.digiwork;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class PagesController {
    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("/users")
    public String usersUrl() {
        return "users/list";
    }
    
    @GetMapping("/users/{pageName}")
    public String usersPage(@PathVariable String pageName) {
        return "users/" + pageName;
    }
    
    @GetMapping("/users/edit/{userId}")
    public String usersPage(@PathVariable Long userId) {
        return "users/add";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }
    
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    
    @GetMapping("/empty")
    public String emptyPage() {
        return "empty_page";
    }
    

}
