package com.example.awsdemo.repositories;

import com.example.awsdemo.models.SecurityGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityGroupRepository extends CrudRepository<SecurityGroup, String> {
}

