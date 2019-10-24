package com.example.awsdemo.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String key;
    private String value;
}
