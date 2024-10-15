package fr.simplon.brief10.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.simplon.brief10.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
