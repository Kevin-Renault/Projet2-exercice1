package com.openclassrooms.projet3.excercice1.repository;

import com.openclassrooms.projet3.excercice1.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByRentalId(Long rentalId);

    List<Message> findByUserId(Long userId);
}
