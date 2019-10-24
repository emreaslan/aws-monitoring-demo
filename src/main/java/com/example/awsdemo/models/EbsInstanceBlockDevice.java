package com.example.awsdemo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data

@Entity
public class EbsInstanceBlockDevice {
    @Id
    private String volumeId;

    private Date attachTime;
    private Boolean deleteOnTermination;
    private String status;
}
