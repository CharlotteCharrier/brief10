package fr.simplon.brief10.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.simplon.brief10.dto.RegisterDto;
import fr.simplon.brief10.model.User;
import fr.simplon.brief10.service.UserService;
import jakarta.validation.Valid;

@Controller
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    //route qui mène à la page d'accueil
    @GetMapping("/home")
    public String home(Model model, Authentication authentication) {
        Optional<User> user = userService.from(authentication);
        if(user.isPresent()){
            model.addAttribute("currentUser", user.get());
        }
        return "forknow-index";
    }

    //route qui mène au formulaire pour créer son compte
    @GetMapping("/register")
    public String register(Model model) {
        RegisterDto user = new RegisterDto();
        model.addAttribute("user", user);
        return "forknow-register";
    }

    //route qui permet de récupérer les données du formulaire de création de compte et qui les stocke en base de données
    @PostMapping("/register/save")
    public String registerUser(@Valid @ModelAttribute RegisterDto userMapping) {
        if(!userMapping.getPassword().equals(userMapping.getConfirmPassword())){
            return "redirect:/register?error";
        }
        userService.saveUser(userMapping);
        return "redirect:/home";
    }

}