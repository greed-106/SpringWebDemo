package com.ymj.webdemo.service.impl;

import com.ymj.webdemo.exception.NotFoundException;
import com.ymj.webdemo.mapper.ContactsMapper;
import com.ymj.webdemo.pojo.Contact;
import com.ymj.webdemo.pojo.DTO.InsertContactRequest;
import com.ymj.webdemo.pojo.DTO.DeleteContactRequest;
import com.ymj.webdemo.pojo.DTO.GetContactRequest;
import com.ymj.webdemo.pojo.DTO.UpdateContactRequest;
import com.ymj.webdemo.service.ContactsService;
import com.ymj.webdemo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsServiceImpl implements ContactsService {
    @Autowired
    ContactsMapper contactsMapper;

    @Override
    public void insertContact(InsertContactRequest insertContactRequest) {
        // 判断name和phone_number是否为空
        if(insertContactRequest.getName() == null || insertContactRequest.getPhoneNumber() == null) {
            throw new IllegalArgumentException("Name and phone number cannot be empty");
        }
        contactsMapper.insertContact(insertContactRequest);
    }

    @Override
    public void updateContact(UpdateContactRequest updateContactRequest) {

        verifyContactId(updateContactRequest.getContactId());
        if(updateContactRequest.getName() == null || updateContactRequest.getPhoneNumber() == null) {
            throw new IllegalArgumentException("Name and phone number cannot be empty");
        }
        contactsMapper.updateContact(updateContactRequest);
    }

    @Override
    public void deleteContact(DeleteContactRequest deleteContactRequest) {
        verifyContactId(deleteContactRequest.getContactId());
        contactsMapper.deleteContact(deleteContactRequest);
    }

    @Override
    public Contact selectContact(GetContactRequest getContactRequest) {
        verifyContactId(getContactRequest.getContactId());
        return contactsMapper.selectContact(getContactRequest);
    }

    @Override
    public List<Contact> selectAllContacts(String username) {
        return contactsMapper.selectAllContacts(username);
    }

    @Override
    public boolean isContactIdExist(int contactId) {
        return contactsMapper.selectContactById(contactId) != null;
    }

    @Override
    public void verifyContactId(int contactId) {
        if(!isContactIdExist(contactId)) {
            throw new NotFoundException("Contact ID not found");
        }
    }
}
