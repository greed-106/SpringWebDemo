package com.ymj.webdemo.mapper;

import com.ymj.webdemo.pojo.DTO.AddContactRequest;
import com.ymj.webdemo.pojo.DTO.DeleteContactRequest;
import com.ymj.webdemo.pojo.DTO.GetContactRequest;
import com.ymj.webdemo.pojo.DTO.UpdateContactRequest;

import com.ymj.webdemo.pojo.Contact;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ContactsMapper {

    @Insert("INSERT INTO contacts (username, name, phone_number, email) VALUES (#{username}, #{name}, #{phone}, #{email})")
    void addContact(AddContactRequest addContactRequest);

    void updateContact(UpdateContactRequest updateContactRequest);

    @Delete("DELETE FROM contacts WHERE username = #{username} AND name = #{name}")
    void deleteContact(DeleteContactRequest deleteContactRequest);

    @Select("SELECT * FROM contacts WHERE username = #{username} AND name = #{name}")
    Contact getContact(GetContactRequest getContactRequest);

    @Select("SELECT * FROM contacts WHERE username = #{username}")
    List<Contact> getAllContacts(String username);
}
