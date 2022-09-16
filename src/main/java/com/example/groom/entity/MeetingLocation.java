package com.example.groom.entity;

import javax.persistence.Embeddable;

@Embeddable
public class MeetingLocation {
    private String address;
    private String longitude;
    private String latitude;
}
