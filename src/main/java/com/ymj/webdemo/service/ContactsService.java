package com.ymj.webdemo.service;

import com.ymj.webdemo.pojo.Contact;
import com.ymj.webdemo.pojo.DTO.InsertContactRequest;
import com.ymj.webdemo.pojo.DTO.DeleteContactRequest;
import com.ymj.webdemo.pojo.DTO.GetContactRequest;
import com.ymj.webdemo.pojo.DTO.UpdateContactRequest;

import java.util.List;

public interface ContactsService {
    void insertContact(InsertContactRequest insertContactRequest);

    void updateContact(UpdateContactRequest updateContactRequest);

    void deleteContact(DeleteContactRequest deleteContactRequest);

    Contact selectContact(GetContactRequest getContactRequest);

    List<Contact> selectAllContacts(String username);

    boolean isContactIdExist(int contactId);

    void verifyContactId(int contactId);
}
