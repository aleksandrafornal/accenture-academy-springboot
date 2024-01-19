package com.accenture.academy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.http.HttpClient;

@Configuration
public class ChurchAcademyConfig {

    @Bean
    HttpClient httpClient(){
        return HttpClient.newBuilder().build();
    }
}
