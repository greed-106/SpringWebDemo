package com.ymj.webdemo.mapper;

import com.ymj.webdemo.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UsersMapper {
    // 根据用户名查询用户
    @Select("SELECT * FROM users WHERE username = #{username}")
    User selectUserByUsername(String username);

    // 添加用户
    @Insert("INSERT INTO users (username, password) VALUES (#{username}, #{password})")
    void insertUser(User user);

    // 更新用户
    void updateUser(User user);

    // 删除用户
    @Delete("DELETE FROM users WHERE username = #{username}")
    void deleteUser(String username);

    // 查询所有用户
    @Select("SELECT * FROM users")
    List<User> selectAllUser();

    // 根据用户名和密码查询用户
    @Select("SELECT * FROM users WHERE username = #{username} AND password = #{password}")
    User selectUserByUsernameAndPassword(User user);
}
