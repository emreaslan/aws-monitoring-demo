package com.example.awsdemo.services;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:aws.properties")
public class EC2 {
    @Value("${cloud.aws.credentials.access-key}")
    private String key;

    @Value("${cloud.aws.credentials.secret-key}")
    private String password;

    @Bean
    AmazonEC2 getEC2() {
        return new AmazonEC2Client(new BasicAWSCredentials(key, password));
    }
}
