package com.openclassrooms.projet3.excercice1.controller;

import com.openclassrooms.projet3.excercice1.dto.MessageDto;
import com.openclassrooms.projet3.excercice1.service.MessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<MessageDto> create(@Valid @RequestBody MessageDto messageDto) {
        MessageDto createdMessage = messageService.create(messageDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMessage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDto> findById(@PathVariable Long id) {
        MessageDto message = messageService.findById(id);
        return ResponseEntity.ok(message);
    }

    @GetMapping
    public ResponseEntity<List<MessageDto>> findAll() {
        List<MessageDto> messages = messageService.findAll();
        return ResponseEntity.ok(messages);
    }

    @GetMapping("/rental/{rentalId}")
    public ResponseEntity<List<MessageDto>> findByRentalId(@PathVariable Long rentalId) {
        List<MessageDto> messages = messageService.findByRentalId(rentalId);
        return ResponseEntity.ok(messages);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<MessageDto>> findByUserId(@PathVariable Long userId) {
        List<MessageDto> messages = messageService.findByUserId(userId);
        return ResponseEntity.ok(messages);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDto> update(@PathVariable Long id, @Valid @RequestBody MessageDto messageDto) {
        MessageDto updatedMessage = messageService.update(id, messageDto);
        return ResponseEntity.ok(updatedMessage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        messageService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
