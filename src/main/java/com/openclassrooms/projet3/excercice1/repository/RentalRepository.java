package com.openclassrooms.projet3.excercice1.repository;

import com.openclassrooms.projet3.excercice1.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

    List<Rental> findByOwnerId(Long ownerId);
}
