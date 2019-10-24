package com.example.awsdemo.services;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataCollectionService {
    private final AmazonEC2 amazonEC2;
    private VolumeService volumeService;
    private SecurityGroupService securityGroupService;
    private InstanceService instanceService;

    private com.example.awsdemo.models.Volume convertToEntity(Volume volume){
        ModelMapper modelMapper = new ModelMapper();
        PropertyMap<VolumeAttachment, com.example.awsdemo.models.VolumeAttachment> propertyMap =
                new PropertyMap<VolumeAttachment, com.example.awsdemo.models.VolumeAttachment>() {
                    protected void configure() {
                        map().setId(null);
                    }
                };
        modelMapper.addMappings(propertyMap);
        List<VolumeAttachment> vaListRetrieved = volume.getAttachments();
        List<com.example.awsdemo.models.VolumeAttachment> vaListCreated = new ArrayList<>();
        vaListRetrieved.forEach(a -> {
            com.example.awsdemo.models.VolumeAttachment attachment =
                    new com.example.awsdemo.models.VolumeAttachment();
            modelMapper.map(a, attachment);
            vaListCreated.add(attachment);
        });

        List<com.example.awsdemo.models.Tag> tagListCreated = new ArrayList<>();
        volume.getTags().forEach(t->{
            com.example.awsdemo.models.Tag tag = new com.example.awsdemo.models.Tag();
            modelMapper.map(t, tag);
            tagListCreated.add(tag);
        });
        return new com.example.awsdemo.models.Volume(
                volume.getVolumeId(),
                vaListCreated, tagListCreated, volume.getAvailabilityZone(), volume.getCreateTime(), volume.getEncrypted(),
                volume.getKmsKeyId(), volume.getSize(), volume.getSnapshotId(), volume.getState(), volume.getIops(),
                volume.getVolumeType());
    }

    private com.example.awsdemo.models.SecurityGroup convertToEntity(SecurityGroup securityGroup){
        ModelMapper modelMapper = new ModelMapper();
        com.example.awsdemo.models.SecurityGroup securityGroupEntity = new com.example.awsdemo.models.SecurityGroup();
        modelMapper.map(securityGroup, securityGroupEntity);
        return securityGroupEntity;
    }

    private com.example.awsdemo.models.Instance convertToEntity(Instance instance){
        ModelMapper modelMapper = new ModelMapper();
        com.example.awsdemo.models.Instance instanceEntity = new com.example.awsdemo.models.Instance();
        modelMapper.map(instance, instanceEntity);
        return instanceEntity;
    }

    public DataCollectionService(AmazonEC2 amazonEC2, VolumeService volumeService,
                                 SecurityGroupService securityGroupService, InstanceService instanceService) {
        this.amazonEC2 = amazonEC2;
        this.volumeService = volumeService;
        this.securityGroupService = securityGroupService;
        this.instanceService = instanceService;
    }

    public void getVolumes() {
        boolean done = false;

        DescribeVolumesRequest request = new DescribeVolumesRequest();
        while (!done) {
            DescribeVolumesResult response = amazonEC2.describeVolumes(request);

            for (Volume volume : response.getVolumes()) {
                volumeService.save(convertToEntity(volume));
            }

            request.setNextToken(response.getNextToken());

            if (response.getNextToken() == null) {
                done = true;
            }
        }
    }

    public void getSecurityGroups() {
        boolean done = false;
        DescribeSecurityGroupsRequest request = new DescribeSecurityGroupsRequest();
        while (!done) {
            DescribeSecurityGroupsResult response = amazonEC2.describeSecurityGroups(request);

            for (SecurityGroup securityGroup : response.getSecurityGroups()) {
                securityGroupService.save(convertToEntity(securityGroup));
            }

            request.setNextToken(response.getNextToken());

            if (response.getNextToken() == null) {
                done = true;
            }
        }
    }

    public void getInstances() {
        boolean done = false;
        DescribeInstancesRequest request = new DescribeInstancesRequest();
        while (!done) {
            DescribeInstancesResult response = amazonEC2.describeInstances(request);

            for (Reservation reservation : response.getReservations()) {
                for (Instance instance : reservation.getInstances()) {
                    instanceService.save(convertToEntity(instance));
                }
            }

            request.setNextToken(response.getNextToken());

            if (response.getNextToken() == null) {
                done = true;
            }
        }
    }

    public void collectAll() {
        getSecurityGroups();
        getVolumes();
        getInstances();
    }
}
