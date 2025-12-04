package com.openclassrooms.projet3.excercice1.controller;

import com.openclassrooms.projet3.excercice1.dto.RentalDto;
import com.openclassrooms.projet3.excercice1.service.RentalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;

    @PostMapping
    public ResponseEntity<RentalDto> create(@Valid @RequestBody RentalDto rentalDto) {
        RentalDto createdRental = rentalService.create(rentalDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRental);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalDto> findById(@PathVariable Long id) {
        RentalDto rental = rentalService.findById(id);
        return ResponseEntity.ok(rental);
    }

    @GetMapping
    public ResponseEntity<List<RentalDto>> findAll() {
        List<RentalDto> rentals = rentalService.findAll();
        return ResponseEntity.ok(rentals);
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<RentalDto>> findByOwnerId(@PathVariable Long ownerId) {
        List<RentalDto> rentals = rentalService.findByOwnerId(ownerId);
        return ResponseEntity.ok(rentals);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentalDto> update(@PathVariable Long id, @Valid @RequestBody RentalDto rentalDto) {
        RentalDto updatedRental = rentalService.update(id, rentalDto);
        return ResponseEntity.ok(updatedRental);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        rentalService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
