package com.dev6.Webfoodapp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "com.dev6.webfoodapp")
@Data
public class CustomProperties {

    private String apiUrl;
    private String apiKey;

}
