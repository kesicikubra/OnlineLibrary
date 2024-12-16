package com.example.MyOnlineLibrary.contactmessage.repository;

import com.example.MyOnlineLibrary.contactmessage.entity.ContactMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface ContactMessageRepository extends JpaRepository<ContactMessage, UUID> {
    Page<ContactMessage> findAllByEmail(String email, Pageable pageable);

    Page<ContactMessage> findByEmailContainingIgnoreCase(String emailPart, Pageable pageable);

    Optional <ContactMessage> findById (UUID id);

}
