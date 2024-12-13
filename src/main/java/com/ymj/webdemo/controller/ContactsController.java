package com.ymj.webdemo.controller;

import com.ymj.webdemo.pojo.Contact;
import com.ymj.webdemo.pojo.DTO.DeleteContactRequest;
import com.ymj.webdemo.pojo.DTO.GetContactRequest;
import com.ymj.webdemo.pojo.DTO.InsertContactRequest;
import com.ymj.webdemo.pojo.DTO.UpdateContactRequest;
import com.ymj.webdemo.pojo.Result;
import com.ymj.webdemo.service.ContactsService;
import com.ymj.webdemo.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ContactsController {
    @Autowired
    ContactsService contactsService;
    @Autowired
    UsersService usersService;

    @GetMapping("/address/contacts/{username}")
    public Result getAllContacts(@PathVariable String username) {

        usersService.verifyUsername(username);
        List<Contact> contacts = contactsService.selectAllContacts(username);

        return Result.success(contacts);
    }

    @GetMapping("/address/contacts/{username}/{contactId}")
    public Result selectContact(@PathVariable String username, @PathVariable int contactId) {
        usersService.verifyUsername(username);
        Contact contact = contactsService.selectContact(new GetContactRequest(username, contactId));
        return Result.success(contact);
    }

    @PostMapping("/address/contacts")
    public Result insertContact(@RequestBody InsertContactRequest insertContactRequest) {
        usersService.verifyUsername(insertContactRequest.getUsername());
        contactsService.insertContact(insertContactRequest);
        return Result.success();
    }

    @PostMapping("/address/contacts/update")
    public Result updateContact(@RequestBody UpdateContactRequest updateContactRequest) {
        usersService.verifyUsername(updateContactRequest.getUsername());
        contactsService.updateContact(updateContactRequest);
        return Result.success();
    }

    @DeleteMapping("/address/contacts/{username}/{contactId}")
    public Result deleteContact(@PathVariable String username, @PathVariable int contactId) {
        usersService.verifyUsername(username);
        contactsService.deleteContact(new DeleteContactRequest(username, contactId));
        return Result.success();
    }
}