package com.example.MyOnlineLibrary.contactmessage.controller;

import com.example.MyOnlineLibrary.contactmessage.payload.request.ContactMessageRequest;
import com.example.MyOnlineLibrary.contactmessage.payload.response.ContactMessageResponse;
import com.example.MyOnlineLibrary.contactmessage.service.ContactMessageService;
import com.example.MyOnlineLibrary.payload.response.ResponseMessage;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contactmessages")
public class ContactMessageController {

    private ContactMessageService service;

    @PostMapping("/save")
  ///  @Operation(tags = "Contact Message",summary = "J01")
    public ResponseMessage<ContactMessageResponse> save(@RequestBody @Valid ContactMessageRequest contactMessageRequest) {
        return service.saveMessage(contactMessageRequest);
    }
}
