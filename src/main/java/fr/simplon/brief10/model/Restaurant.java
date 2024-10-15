package fr.simplon.brief10.model;

import java.util.Date;

import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Ici on définit les champs dont on a besoin en base de données
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name= "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    private Date creation_date;

    private String image;

    private String food_style;
}
