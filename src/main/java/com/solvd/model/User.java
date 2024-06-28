package com.solvd.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class User {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String address;

    private int apartment;

    private String postalCode;

    private String city;

    private String phone;

    private String cardNumber;

    private String expirationDate;

    private String securityCode;

    private String nameOnCard;
}
