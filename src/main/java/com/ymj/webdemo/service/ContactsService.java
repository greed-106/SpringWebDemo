package com.ymj.webdemo.service;

import com.ymj.webdemo.pojo.DTO.AddContactRequest;
import com.ymj.webdemo.pojo.DTO.DeleteContactRequest;
import com.ymj.webdemo.pojo.DTO.GetContactRequest;
import com.ymj.webdemo.pojo.DTO.UpdateContactRequest;

public interface ContactsService {
    void addContact(AddContactRequest addContactRequest);

    void updateContact(UpdateContactRequest updateContactRequest);

    void deleteContact(DeleteContactRequest deleteContactRequest);

    void getContact(GetContactRequest getContactRequest);

    void getAllContacts(String username);
}
