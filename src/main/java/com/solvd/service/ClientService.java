package com.solvd.service;

import com.solvd.model.Client;

public class ClientService {

    public static Client createClient() {
        return new Client("John", "Smith", "john.smith@email.com", "Street",
                101, "12345", "City", "123456789", "1111111111111111",
                "1225", "123", "John Smith");
    }

}