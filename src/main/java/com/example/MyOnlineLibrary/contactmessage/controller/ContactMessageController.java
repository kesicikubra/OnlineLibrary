package com.example.MyOnlineLibrary.contactmessage.controller;

import com.example.MyOnlineLibrary.contactmessage.payload.request.ContactMessageRequest;
import com.example.MyOnlineLibrary.contactmessage.payload.response.ContactMessageResponse;
import com.example.MyOnlineLibrary.contactmessage.service.ContactMessageService;
import com.example.MyOnlineLibrary.payload.response.ResponseMessage;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contactmessages")
public class ContactMessageController {

    private ContactMessageService service;

    @PostMapping
  ///  @Operation(tags = "Contact Message",summary = "J01")
    public ResponseMessage<ContactMessageResponse> save(@RequestBody @Valid ContactMessageRequest contactMessageRequest) {
        return service.saveMessage(contactMessageRequest);
    }

    @GetMapping
    public ResponseMessage<ContactMessageResponse> getById(@RequestParam(value = "contactMessageId") UUID contactMessageId){
        return service.getContactMessageById(contactMessageId);
    }

    @GetMapping
    public ResponseMessage<Page<ContactMessageResponse>>  getAllContactMessagesByPages(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "dateTime") String sort,
            @RequestParam(value = "type", defaultValue = "desc") String type){

        return service.getAllContactMessagesByPages(page, size, sort, type);
    }
    @GetMapping("/status")
    public ResponseMessage<Page<ContactMessageResponse>>  getAllContactMessagesByPages(
            @RequestParam(value = "q" ,required = false) String q,
            @RequestParam(value = "status" ,required = false) String status,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "dateTime") String sort,
            @RequestParam(value = "type", defaultValue = "desc") String type){

        return service.getAllContactMessagesWithStatusByPages(q,status,page,size,sort,type);
    }



}
