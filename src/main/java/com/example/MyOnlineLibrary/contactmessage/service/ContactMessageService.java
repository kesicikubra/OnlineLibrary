package com.example.MyOnlineLibrary.contactmessage.service;

import com.example.MyOnlineLibrary.contactmessage.entity.ContactMessage;
import com.example.MyOnlineLibrary.contactmessage.entity.Status;
import com.example.MyOnlineLibrary.contactmessage.payload.mapper.ContactMessageMapper;
import com.example.MyOnlineLibrary.contactmessage.payload.request.ContactMessageRequest;
import com.example.MyOnlineLibrary.contactmessage.payload.response.ContactMessageResponse;
import com.example.MyOnlineLibrary.contactmessage.repository.ContactMessageRepository;
import com.example.MyOnlineLibrary.exception.BadRequestException;
import com.example.MyOnlineLibrary.exception.InvalidDataException;
import com.example.MyOnlineLibrary.payload.response.ResponseMessage;
import com.example.MyOnlineLibrary.service.helper.PageableHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContactMessageService {

    private final ContactMessageRepository contactMessageRepository;
    private final ContactMessageMapper contactMessageMapper;
    private final PageableHelper pageableHelper;

    public ResponseMessage<ContactMessageResponse> saveMessage(ContactMessageRequest contactMessageRequest) {
      ContactMessage contactMessage = contactMessageMapper.requestToContactMessage(contactMessageRequest);
      contactMessage.setStatus(Status.UNREAD);
      ContactMessage savedContactMessage= contactMessageRepository.save(contactMessage);
      ContactMessageResponse contactMessageResponse = contactMessageMapper.contactMessageToResponse(savedContactMessage);
      return ResponseMessage.<ContactMessageResponse>builder()
              .httpStatus(HttpStatus.OK).
              object(contactMessageResponse).build();
  }

    public ResponseMessage<ContactMessageResponse> getContactMessageById(UUID contactMessageId) {

     ContactMessage contactMessage = contactMessageRepository.findById(contactMessageId).orElseThrow(()->new InvalidDataException("Data is invalid"));
        ContactMessageResponse contactMessageResponse = contactMessageMapper.contactMessageToResponse(contactMessage);
        return ResponseMessage.<ContactMessageResponse>builder()
                .httpStatus(HttpStatus.OK).
                object(contactMessageResponse).build();
    }

    public ResponseMessage<Page<ContactMessageResponse>> getAllContactMessagesByPages(int page, int size, String sort, String type) {
      Pageable pageable =  pageableHelper.getPageableWithProperties(page, size, sort, type);
        Page<ContactMessageResponse> contactMessageResponsePage = contactMessageRepository.findAll(pageable)
                .map(contactMessageMapper::contactMessageToResponse);

        return ResponseMessage.<Page<ContactMessageResponse>>builder()
                .httpStatus(HttpStatus.OK)
                .object(contactMessageResponsePage)
                .build();
    }

    public ResponseMessage<Page<ContactMessageResponse>> getAllContactMessagesWithStatusByPages(String q,String requestStatus, int page, int size, String sort, String type ) {
        Pageable pageable =  pageableHelper.getPageableWithProperties(page, size, sort, type);

        Status status = null;
        if (Status.READ.getName().equalsIgnoreCase(requestStatus)){
            status = Status.READ;
        } else if (Status.UNREAD.getName().equalsIgnoreCase(requestStatus)) {
            status = Status.UNREAD;
        } else if (!Objects.isNull(requestStatus) && !requestStatus.equalsIgnoreCase("All")){
            throw new BadRequestException(String.format("Invalid", requestStatus));

        }

        Page<ContactMessageResponse> contactMessageResponsePage = contactMessageRepository.findAll(pageable)
                .map(contactMessageMapper::contactMessageToResponse);

        return ResponseMessage.<Page<ContactMessageResponse>>builder()
                .httpStatus(HttpStatus.OK)
                .object(contactMessageResponsePage)
                .build();
    }

    public ResponseMessage<Page<ContactMessageResponse>> searchByEmail(String email, int page, int size, String sort, String type) {



        Pageable pageable = pageableHelper.getPageableWithProperties(page, size, sort, type);

        Page<ContactMessageResponse> contactMessagesByEmail=contactMessageRepository.findByEmailContainingIgnoreCase(email,pageable)
                .map(contactMessageMapper::contactMessageToResponse);

        return ResponseMessage.<Page<ContactMessageResponse>>builder()
                .httpStatus(HttpStatus.OK)
                .object(contactMessagesByEmail)
                .build();






    }
}
