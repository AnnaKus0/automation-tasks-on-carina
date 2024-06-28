package com.solvd.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {

    private String firstName;

    private String lastName;

    private String email;

    private String address;

    private int apartment;

    private String postalCode;

    private String city;

    private String phone;

    private String cardNumber;

    private String expirationDate;

    private String securityCode;

    private String nameOnCard;

    public User(String firstName, String lastName, String email, String address, int apartment, String postalCode,
                  String city, String phone, String cardNumber, String expirationDate, String securityCode, String nameOnCard) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.apartment = apartment;
        this.postalCode = postalCode;
        this.city = city;
        this.phone = phone;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
        this.nameOnCard = nameOnCard;
    }
}
