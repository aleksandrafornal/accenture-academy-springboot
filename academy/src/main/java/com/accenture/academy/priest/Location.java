package com.accenture.academy.priest;

import jakarta.persistence.Embeddable;

@Embeddable
public class Location {
    String city;
    String street;
    String numberOfStreet;
}
