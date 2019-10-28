package com.example.awsdemo.services;

import com.example.awsdemo.models.SecurityGroup;
import com.example.awsdemo.repositories.SecurityGroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SecurityGroupServiceImpl implements SecurityGroupService {
    private final SecurityGroupRepository repository;

    public SecurityGroupServiceImpl(SecurityGroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<SecurityGroup> getInstanceById(String id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public void save(SecurityGroup instance) {
        repository.save(instance);
    }

    @Override
    public List<SecurityGroup> getInstancesList() {
        List<SecurityGroup> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }
}
