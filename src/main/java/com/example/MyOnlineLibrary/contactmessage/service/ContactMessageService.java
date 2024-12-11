package com.example.MyOnlineLibrary.contactmessage.service;

import com.example.MyOnlineLibrary.contactmessage.entity.ContactMessage;
import com.example.MyOnlineLibrary.contactmessage.entity.Status;
import com.example.MyOnlineLibrary.contactmessage.payload.mapper.ContactMessageMapper;
import com.example.MyOnlineLibrary.contactmessage.payload.request.ContactMessageRequest;
import com.example.MyOnlineLibrary.contactmessage.payload.response.ContactMessageResponse;
import com.example.MyOnlineLibrary.contactmessage.repository.ContactMessageRepository;
import com.example.MyOnlineLibrary.payload.response.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactMessageService {

    private final ContactMessageRepository contactMessageRepository;
    private final ContactMessageMapper contactMessageMapper;

    public ResponseMessage<ContactMessageResponse> saveMessage(ContactMessageRequest contactMessageRequest) {
      ContactMessage contactMessage = contactMessageMapper.requestToContactMessage(contactMessageRequest);
      contactMessage.setStatus(Status.UNREAD);
      ContactMessage savedContactMessage= contactMessageRepository.save(contactMessage);
      ContactMessageResponse contactMessageResponse = contactMessageMapper.contactMessageToResponse(savedContactMessage);
      return ResponseMessage.<ContactMessageResponse>builder()
              .httpStatus(HttpStatus.OK).
              object(contactMessageResponse).build();
  }
}
