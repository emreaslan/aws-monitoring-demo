package com.example.awsdemo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data

@Entity
public class GroupIdentifier {
    @Id
    private String groupId;
    private String groupName;
}
