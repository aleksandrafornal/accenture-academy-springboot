package com.accenture.academy.apiConsuming;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Activity {
    private String activity;
    private String type;
    private Integer participants;
    private Double price;
    private String link;
    @Id
    @Column(name = "activityKey")
    private String key;
    private Double accessibility;
}

//{"activity":"Take a bubble bath",
// "type":"relaxation",
// "participants":1,
// "price":0.15,
// "link":"",
// "key":"2581372",
// "accessibility":0.1}
