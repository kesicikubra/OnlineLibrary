package com.example.MyOnlineLibrary.contactmessage.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ContactMessageRequest(
        @Size(max = 250, min = 2)
        @NotBlank(message =" ")
        String message,

        @NotNull
        @Email
        String eMail,

        @Size(max = 50 )
        String subject

) {
}
