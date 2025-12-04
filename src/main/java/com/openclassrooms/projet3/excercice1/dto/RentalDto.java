package com.openclassrooms.projet3.excercice1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalDto {

    private Long id;

    @NotBlank(message = "Le nom est obligatoire")
    @Size(max = 255, message = "Le nom ne peut pas dépasser 255 caractères")
    private String name;

    @NotNull(message = "La surface est obligatoire")
    @Positive(message = "La surface doit être positive")
    private Integer surface;

    @NotNull(message = "Le prix est obligatoire")
    @Positive(message = "Le prix doit être positif")
    private Integer price;

    @Size(max = 1000, message = "L'URL de l'image ne peut pas dépasser 1000 caractères")
    private String picture;

    @Size(max = 2000, message = "La description ne peut pas dépasser 2000 caractères")
    private String description;

    @NotNull(message = "L'ID du propriétaire est obligatoire")
    @Positive(message = "L'ID du propriétaire doit être positif")
    private Long ownerId;

    @PastOrPresent(message = "La date de création ne peut pas être dans le futur")
    private LocalDateTime createdAt;

    @PastOrPresent(message = "La date de mise à jour ne peut pas être dans le futur")
    private LocalDateTime updatedAt;

    /**
     * Valide tous les paramètres du DTO
     * 
     * @return Liste des messages d'erreur, vide si tout est valide
     */
    public List<String> validate() {
        List<String> errors = new ArrayList<>();

        if (name == null || name.isBlank()) {
            errors.add("Le nom est obligatoire");
        } else if (name.length() > 255) {
            errors.add("Le nom ne peut pas dépasser 255 caractères");
        }

        if (surface == null) {
            errors.add("La surface est obligatoire");
        } else if (surface <= 0) {
            errors.add("La surface doit être positive");
        }

        if (price == null) {
            errors.add("Le prix est obligatoire");
        } else if (price <= 0) {
            errors.add("Le prix doit être positif");
        }

        if (picture != null && picture.length() > 1000) {
            errors.add("L'URL de l'image ne peut pas dépasser 1000 caractères");
        }

        if (description != null && description.length() > 2000) {
            errors.add("La description ne peut pas dépasser 2000 caractères");
        }

        if (ownerId == null) {
            errors.add("L'ID du propriétaire est obligatoire");
        } else if (ownerId <= 0) {
            errors.add("L'ID du propriétaire doit être positif");
        }

        if (createdAt != null && createdAt.isAfter(LocalDateTime.now())) {
            errors.add("La date de création ne peut pas être dans le futur");
        }

        if (updatedAt != null && updatedAt.isAfter(LocalDateTime.now())) {
            errors.add("La date de mise à jour ne peut pas être dans le futur");
        }

        return errors;
    }
}
