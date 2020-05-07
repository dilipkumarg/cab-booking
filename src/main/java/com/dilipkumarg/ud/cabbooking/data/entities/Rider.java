package com.dilipkumarg.ud.cabbooking.data.entities;

import lombok.Data;

@Data
public class Rider {
    private String riderId;
    private User user;

    private String emergencyContact;
}
