package com.example.awsdemo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Volume {
    @Id
    private String volumeId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "volumeId")
    private List<VolumeAttachment> attachments;

    @JoinTable
    @OneToMany(cascade = CascadeType.ALL)
    private List<Tag> tags;

    private String availabilityZone;
    private Date createTime;
    private Boolean encrypted;
    private String kmsKeyId;
    private Integer size;
    private String snapshotId;
    private String state;
    private Integer iops;
    private String volumeType;
}
