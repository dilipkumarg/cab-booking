package com.dilipkumarg.ud.cabbooking.data.entities;

import java.time.Instant;

import lombok.Data;

@Data
public class User {
    private String userId;
    private String email;
    private String phoneNumber;

    private Instant joinedAt = Instant.now();
}
