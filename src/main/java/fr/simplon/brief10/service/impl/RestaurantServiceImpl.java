package fr.simplon.brief10.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.simplon.brief10.dto.RestaurantDto;
import fr.simplon.brief10.model.Restaurant;
import fr.simplon.brief10.repository.RestaurantRepository;
import fr.simplon.brief10.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public void saveRestaurant(RestaurantDto restaurant) {
        Restaurant restaurantEntity = Restaurant.builder().name(restaurant.getName()).image(restaurant.getImage()).food_style(restaurant.getFood_style()).build();
        restaurantRepository.save(restaurantEntity);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
       return restaurantRepository.findAll();
    }
}
