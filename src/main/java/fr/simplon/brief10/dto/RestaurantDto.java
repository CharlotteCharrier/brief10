package fr.simplon.brief10.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//informations remontées du formulaire pour ajouter un nouveau restaurant

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {

    @NotEmpty(message = "Name of the shop must not be empty")
    private String name;

    private String image;

    private String food_style;

}
