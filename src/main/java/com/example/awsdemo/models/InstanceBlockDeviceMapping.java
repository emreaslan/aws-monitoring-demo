package com.example.awsdemo.models;

import lombok.Data;

import javax.persistence.*;

@Data

@Entity
public class InstanceBlockDeviceMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="instanceBlockDeviceMapping")
    private EbsInstanceBlockDevice ebs;

    private String deviceName;
}