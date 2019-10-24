package com.example.awsdemo.services;

import com.example.awsdemo.models.Instance;
import com.example.awsdemo.repositories.InstanceRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InstanceServiceImpl implements InstanceService {
    private InstanceRepository repository;

    public InstanceServiceImpl(InstanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Instance> getInstanceById(String id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public void save(Instance instance) {
        repository.save(instance);
    }

    @Override
    public List<Instance> getInstancesList() {
        List<Instance> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }
}
