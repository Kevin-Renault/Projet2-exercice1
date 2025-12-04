package com.openclassrooms.projet3.excercice1.mapper;

import com.openclassrooms.projet3.excercice1.dto.MessageDto;
import com.openclassrooms.projet3.excercice1.entity.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {

    public MessageDto toDto(Message message) {
        if (message == null) {
            return null;
        }

        MessageDto dto = new MessageDto();
        dto.setId(message.getId());
        dto.setRentalId(message.getRental() != null ? message.getRental().getId() : null);
        dto.setUserId(message.getUser() != null ? message.getUser().getId() : null);
        dto.setMessage(message.getMessage());
        dto.setCreatedAt(message.getCreatedAt());
        dto.setUpdatedAt(message.getUpdatedAt());

        return dto;
    }

    public Message toEntity(MessageDto dto) {
        if (dto == null) {
            return null;
        }

        Message message = new Message();
        message.setId(dto.getId());
        message.setMessage(dto.getMessage());
        message.setCreatedAt(dto.getCreatedAt());
        message.setUpdatedAt(dto.getUpdatedAt());

        // Note: rental et user doivent être définis séparément car on a seulement les
        // IDs dans le DTO

        return message;
    }

    public void updateEntityFromDto(MessageDto dto, Message message) {
        if (dto == null || message == null) {
            return;
        }

        message.setMessage(dto.getMessage());
    }
}
