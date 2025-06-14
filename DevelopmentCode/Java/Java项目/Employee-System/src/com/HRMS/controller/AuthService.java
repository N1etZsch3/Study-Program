package com.HRMS.controller;

import com.HRMS.model.User;

import java.security.MessageDigest;
import java.util.List;

public class AuthService {
    public static boolean authenticate(String username, String password, boolean isAdmin) {
        List<User> users = FileUtil.readUsers();
        String hashedPassword = md5(password);

        for (User user : users) {
            if (user.getUsername().equals(username) &&
                    user.getPassword().equals(hashedPassword) &&
                    user.isAdmin() == isAdmin) {
                return true;
            }
        }
        return false;
    }

    public static boolean register(String username, String password, boolean isAdmin) {
        List<User> users = FileUtil.readUsers();

        // 检查用户名是否已存在
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }

        // 添加新用户
        users.add(new User(username, md5(password), isAdmin));
        FileUtil.saveUsers(users);
        return true;
    }

    public static String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

