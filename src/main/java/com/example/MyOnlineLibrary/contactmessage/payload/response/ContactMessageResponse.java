package com.example.MyOnlineLibrary.contactmessage.payload.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

public class ContactMessageResponse {

    private UUID id;
    private String message;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    private String eMail;

    private String subject;
}
