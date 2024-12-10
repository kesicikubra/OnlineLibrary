package com.example.MyOnlineLibrary.contactmessage.controller;

import com.example.MyOnlineLibrary.contactmessage.payload.request.ContactMessageRequest;
import com.example.MyOnlineLibrary.contactmessage.payload.response.ContactMessageResponse;
import com.example.MyOnlineLibrary.contactmessage.service.ContactMessageService;
import com.example.MyOnlineLibrary.payload.response.ResponseMessage;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contactmessages")
public class ContactMessageController {

    private ContactMessageService service;

    @PostMapping
    private ResponseMessage<ContactMessageResponse> saveContactMessage(@Valid @ModelAttribute ContactMessageRequest contactMessageRequest){
    return service.saveMessage(contactMessageRequest);
    }

}
