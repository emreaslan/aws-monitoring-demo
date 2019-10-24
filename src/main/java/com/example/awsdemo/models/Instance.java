package com.example.awsdemo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data

@Entity
public class Instance {
    @Id
    private String instanceId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instance_state")
    private InstanceState state;

    @JoinTable
    @OneToMany(cascade = CascadeType.ALL)
    private List<InstanceBlockDeviceMapping> blockDeviceMappings;

    @JoinTable
    @OneToMany(cascade = CascadeType.ALL)
    private List<GroupIdentifier> securityGroups;

    @JoinTable
    @OneToMany(cascade = CascadeType.ALL)
    private List<Tag> tags;

    private Integer amiLaunchIndex;
    private String imageId;
    private String instanceType;
    private String kernelId;
    private String keyName;
    private Date launchTime;
    private String platform;
    private String privateDnsName;
    private String privateIpAddress;
    private String publicDnsName;
    private String publicIpAddress;
    private String ramdiskId;
    private String stateTransitionReason;
    private String subnetId;
    private String vpcId;
    private String architecture;
    private String clientToken;
    private Boolean ebsOptimized;
    private Boolean enaSupport;
    private String hypervisor;
    private String instanceLifecycle;
    private String rootDeviceName;
    private String rootDeviceType;
    private Boolean sourceDestCheck;
    private String spotInstanceRequestId;
    private String sriovNetSupport;
    private String virtualizationType;

    /* The members below ignored for simplicity (because of limited time) */
    //private Monitoring monitoring;
    //private Placement placement;
    //private List<ProductCode> productCodes;
    //private IamInstanceProfile iamInstanceProfile;
    //private List<ElasticGpuAssociation> elasticGpuAssociations;
    //private List<InstanceNetworkInterface> networkInterfaces;
    //private StateReason stateReason;
    //private CpuOptions cpuOptions;
}
