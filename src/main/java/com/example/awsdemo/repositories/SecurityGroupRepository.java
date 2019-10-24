package com.example.awsdemo.repositories;

import com.example.awsdemo.models.SecurityGroup;
import org.springframework.data.repository.CrudRepository;

public interface SecurityGroupRepository extends CrudRepository<SecurityGroup, String> {
}

