package com.accenture.academy.apiConsuming;

import lombok.Data;

@Data
public class Joke {
    private String type;
    private String setup;
    private String punchline;
    private Integer id;
}
