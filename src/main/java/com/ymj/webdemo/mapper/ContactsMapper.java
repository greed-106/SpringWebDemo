package com.ymj.webdemo.mapper;

import com.ymj.webdemo.pojo.DTO.InsertContactRequest;
import com.ymj.webdemo.pojo.DTO.DeleteContactRequest;
import com.ymj.webdemo.pojo.DTO.GetContactRequest;
import com.ymj.webdemo.pojo.DTO.UpdateContactRequest;

import com.ymj.webdemo.pojo.Contact;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ContactsMapper {

    @Insert("INSERT INTO contacts (username, name, phone_number, email) VALUES (#{username}, #{name}, #{phoneNumber}, #{email})")
    void insertContact(InsertContactRequest insertContactRequest);

    void updateContact(UpdateContactRequest updateContactRequest);

    @Delete("DELETE FROM contacts WHERE username = #{username} AND contact_id = #{contactId}")
    void deleteContact(DeleteContactRequest deleteContactRequest);

    @Select("SELECT * FROM contacts WHERE username = #{username} AND contact_id = #{contactId}")
    Contact selectContact(GetContactRequest getContactRequest);

    @Select("SELECT * FROM contacts WHERE username = #{username}")
    List<Contact> selectAllContacts(String username);

    @Select("SELECT * FROM contacts WHERE contact_id = #{contactId}")
    Contact selectContactById(int contactId);
}
