package com.example.awsdemo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data

@Entity
public class InstanceState{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private Integer code;
    private String name;
}
