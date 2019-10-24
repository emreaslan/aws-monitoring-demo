package com.example.awsdemo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data

@Entity
public class SecurityGroup {
    @Id
    private String groupId;

    private String description;
    private String groupName;
    private String ownerId;
    private String vpcId;

    @JoinTable
    @OneToMany(cascade = CascadeType.ALL)
    private List<Tag> tags;

    /* The members below ignored for simplicity (because of limited time) */
    //private List<IpPermission> ipPermissions;
    //private List<IpPermission> ipPermissionsEgress;
}
