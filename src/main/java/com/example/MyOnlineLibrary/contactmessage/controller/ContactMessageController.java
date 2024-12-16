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

    private ContactMessageService contactMessageService;

    @PostMapping
    public ResponseMessage<ContactMessageResponse> save(@RequestBody @Valid ContactMessageRequest contactMessageRequest) {
        return contactMessageService.saveMessage(contactMessageRequest);
    }

    @GetMapping("/getById")
    public ResponseMessage<ContactMessageResponse> getById(@RequestParam(value = "contactMessageId") UUID contactMessageId){
        return contactMessageService.getContactMessageById(contactMessageId);
    }

    @GetMapping
    public ResponseMessage<Page<ContactMessageResponse>>  getAllContactMessagesByPages(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "dateTime") String sort,
            @RequestParam(value = "type", defaultValue = "desc") String type){

        return contactMessageService.getAllContactMessagesByPages(page, size, sort, type);
    }
    @GetMapping("/status")
    public ResponseMessage<Page<ContactMessageResponse>>  getAllContactMessagesByPages(
            @RequestParam(value = "q" ,required = false) String q,
            @RequestParam(value = "status" ,required = false) String status,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "dateTime") String sort,
            @RequestParam(value = "type", defaultValue = "desc") String type){

        return contactMessageService.getAllContactMessagesWithStatusByPages(q,status,page,size,sort,type);
    }

    @GetMapping("/searchByEmail")
    public ResponseMessage<Page<ContactMessageResponse>>searchByEmail(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "dateTime") String sort,
            @RequestParam(value = "type", defaultValue = "desc") String type
    ){
        return contactMessageService.searchByEmail(email,page,size,sort,type);
    }

    @GetMapping("/{id}")
    public ResponseMessage<ContactMessageResponse> getByIdParam(@PathVariable(name = "id") UUID contactMessageId){
        return contactMessageService.getContactMessageById(contactMessageId) ;
    }




}
