package com.example.MyOnlineLibrary.contactmessage.service;

import com.example.MyOnlineLibrary.contactmessage.payload.request.ContactMessageRequest;
import com.example.MyOnlineLibrary.contactmessage.payload.response.ContactMessageResponse;
import com.example.MyOnlineLibrary.payload.response.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactMessageService {


    public ResponseMessage<ContactMessageResponse> saveMessage(ContactMessageRequest contactMessageRequest) {
     return null;




    }
}
