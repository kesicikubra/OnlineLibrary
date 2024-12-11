package com.example.MyOnlineLibrary.contactmessage.payload.response;

import com.example.MyOnlineLibrary.contactmessage.entity.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

public record ContactMessageResponse(
       UUID id,

       String message,

       String eMail,

       String subject,

       Status status,
       LocalDateTime createAt,

       LocalDateTime updateAt
) {
}
