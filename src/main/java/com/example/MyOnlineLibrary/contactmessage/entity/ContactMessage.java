package com.example.MyOnlineLibrary.contactmessage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ContactMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Size(max = 250, min = 2)
    @NotBlank(message =" ")
    private String message;

    @NotNull
    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    @NotNull
    @Email
    private String eMail;

    @Size(max = 50 )
    private String subject;

}
