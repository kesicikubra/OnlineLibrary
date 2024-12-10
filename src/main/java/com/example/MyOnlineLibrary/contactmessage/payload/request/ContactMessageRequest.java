package com.example.MyOnlineLibrary.contactmessage.payload.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ContactMessageRequest {


    @Size(max = 250, min = 2)
    @NotBlank(message =" ")
    private String message;

    @NotNull
    @Email
    private String eMail;

    @Size(max = 50 )
    private String subject;





}
