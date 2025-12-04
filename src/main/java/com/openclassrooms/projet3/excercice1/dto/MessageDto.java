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
public class MessageDto {

    private Long id;

    @NotNull(message = "L'ID de la location est obligatoire")
    @Positive(message = "L'ID de la location doit être positif")
    private Long rentalId;

    @NotNull(message = "L'ID de l'utilisateur est obligatoire")
    @Positive(message = "L'ID de l'utilisateur doit être positif")
    private Long userId;

    @NotBlank(message = "Le message est obligatoire")
    @Size(max = 2000, message = "Le message ne peut pas dépasser 2000 caractères")
    private String message;

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

        if (rentalId == null) {
            errors.add("L'ID de la location est obligatoire");
        } else if (rentalId <= 0) {
            errors.add("L'ID de la location doit être positif");
        }

        if (userId == null) {
            errors.add("L'ID de l'utilisateur est obligatoire");
        } else if (userId <= 0) {
            errors.add("L'ID de l'utilisateur doit être positif");
        }

        if (message == null || message.isBlank()) {
            errors.add("Le message est obligatoire");
        } else if (message.length() > 2000) {
            errors.add("Le message ne peut pas dépasser 2000 caractères");
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
