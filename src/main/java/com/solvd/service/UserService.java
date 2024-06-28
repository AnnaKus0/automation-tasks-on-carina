package com.solvd.service;

import com.solvd.model.User;

import java.util.Random;

public class UserService {

    private static final Random random = new Random();

    public static User createCheckOutUser() {
        return User.builder()
                .firstName(generateRandomString(8))
                .lastName(generateRandomString(8))
                .email(generateRandomEmail())
                .address(generateRandomString(20))
                .apartment(new Random().nextInt(1000) + 1)
                .postalCode("50-590")
                .city(generateRandomString(8))
                .phone(String.format("%10d", new Random().nextLong(10000000000L)))
                .cardNumber("1234")
                .expirationDate("2125")
                .securityCode("432")
                .nameOnCard(generateRandomString(8))
                .build();
    }

    public static User createSignUpUser() {
        return User.builder()
                .firstName(generateRandomString(8))
                .lastName(generateRandomString(8))
                .email(generateRandomEmail())
                .password(generateRandomPassword())
                .build();
    }

    public static String generateRandomString(int length) {
        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
        }
        return sb.toString();
    }

    public static String generateRandomEmail() {
        return generateRandomString(8) + "@example.com";
    }

    public static String generateRandomPassword() {
        return generateRandomString(10) + "123@#";
    }

}