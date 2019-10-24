package com.example.awsdemo.repositories;

import com.example.awsdemo.models.Volume;
import org.springframework.data.repository.CrudRepository;

public interface VolumeRepository extends CrudRepository<Volume, String> {
}
