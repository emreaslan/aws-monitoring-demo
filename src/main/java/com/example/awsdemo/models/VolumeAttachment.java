package com.example.awsdemo.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data

@Entity
public class VolumeAttachment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="volumeId")
    private Volume volumeId;

    private Date attachTime;
    private String device;
    private String instanceId;
    private String state;
    private Boolean deleteOnTermination;
}
