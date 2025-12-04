package com.openclassrooms.projet3.excercice1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    @NotBlank(message = "Le nom est obligatoire")
    @Size(max = 255, message = "Le nom ne peut pas dépasser 255 caractères")
    private String name;

    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "L'email doit être valide")
    @Size(max = 255, message = "L'email ne peut pas dépasser 255 caractères")
    private String email;

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

        if (email == null || email.isBlank()) {
            errors.add("L'email est obligatoire");
        } else {
            if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                errors.add("L'email doit être valide");
            }
            if (email.length() > 255) {
                errors.add("L'email ne peut pas dépasser 255 caractères");
            }
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
