package fr.simplon.brief10.service;

import java.util.List;

import fr.simplon.brief10.dto.RestaurantDto;
import fr.simplon.brief10.model.Restaurant;

public interface RestaurantService {
 void saveRestaurant(RestaurantDto restaurantMapping);

 List<Restaurant> getAllRestaurants();
}
