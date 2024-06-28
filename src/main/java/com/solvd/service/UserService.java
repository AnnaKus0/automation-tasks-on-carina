package com.solvd.service;

import com.solvd.model.User;

import java.util.Random;

public class UserService {

    public static User createUser() {
        return new User("John", "Smith", "john.smith@email.com", "Street",
                101, "12345", "City", "123456789", "1111111111111111",
                "1225", "123", "John Smith");
    }

    public static String generateRandomString() {
        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
        }
        return sb.toString();
    }

    public static String generateRandomEmail() {
        return generateRandomString() + "@example.com";
    }

    public static String generateRandomPassword() {
        return generateRandomString() + "123@#";
    }

}