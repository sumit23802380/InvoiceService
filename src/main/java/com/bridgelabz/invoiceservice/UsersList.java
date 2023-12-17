package com.bridgelabz.invoiceservice;

import java.util.HashMap;
import java.util.Map;

public class UsersList {
    public static Map<String, User> getUserById = new HashMap<>();
    public static void add(User user){
        getUserById.put(user.userId , user);
    }
}