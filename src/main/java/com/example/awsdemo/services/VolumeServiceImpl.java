package com.example.awsdemo.services;

import com.example.awsdemo.models.Volume;
import com.example.awsdemo.repositories.VolumeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VolumeServiceImpl implements VolumeService {
    private VolumeRepository volumeRepository;

    public VolumeServiceImpl(VolumeRepository volumeRepository) {
        this.volumeRepository = volumeRepository;
    }

    @Override
    public Optional<Volume> getInstanceById(String id) {
        return volumeRepository.findById(id);
    }

    @Override
    public void save(Volume instance) {
        volumeRepository.save(instance);
    }

    @Override
    public List<Volume> getInstancesList() {
        List<Volume> list = new ArrayList<>();
        volumeRepository.findAll().forEach(list::add);
        return list;
    }
}
