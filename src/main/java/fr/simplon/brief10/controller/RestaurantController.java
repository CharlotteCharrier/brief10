package fr.simplon.brief10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.simplon.brief10.dto.RestaurantDto;
import fr.simplon.brief10.model.Restaurant;
import fr.simplon.brief10.service.RestaurantService;
import jakarta.validation.Valid;

@Controller
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    //route qui récupère tous les restaurants présents en base de données
    @GetMapping("/restaurants")
    public String allRestaurants(Model model) {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        model.addAttribute("restaurants", restaurants);
        return "forknow-restaurants-list";
    }

    //route qui permet d'accéder au formulaire pour ajouter un nouveau restaurant en base de données
    @GetMapping("/restaurants/new")
    public String newRestaurant(Model model) {
        RestaurantDto restaurant = new RestaurantDto();
        model.addAttribute("restaurant", restaurant);
        return "forknow-new-restaurant";
    }

    //route qui récupère les infos du formulaire pour ajouter un restaurant et stocke ces infos en base de données
    @PostMapping("/restaurants/save")
    public String saveRestaurant(@Valid @ModelAttribute("restaurant") RestaurantDto restaurantMapping) {
        restaurantService.saveRestaurant(restaurantMapping);
        return "redirect:/restaurants";
    }
}
