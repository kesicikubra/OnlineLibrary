package com.example.MyOnlineLibrary.contactmessage.payload.mapper;

import com.example.MyOnlineLibrary.contactmessage.entity.ContactMessage;
import com.example.MyOnlineLibrary.contactmessage.payload.request.ContactMessageRequest;
import com.example.MyOnlineLibrary.contactmessage.payload.response.ContactMessageResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ContactMessageMapper {

    public abstract ContactMessage requestToContactMessage(ContactMessageRequest contactMessageRequest);


    public abstract ContactMessageResponse contactMessageToResponse(ContactMessage contactMessage);

}
