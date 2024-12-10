package com.example.MyOnlineLibrary.contactmessage.repository;

import com.example.MyOnlineLibrary.contactmessage.entity.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ContactMessageRepostory extends JpaRepository< ContactMessage, UUID> {
}
