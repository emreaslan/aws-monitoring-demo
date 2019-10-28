package com.example.awsdemo.repositories;

import com.example.awsdemo.models.Volume;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolumeRepository extends CrudRepository<Volume, String> {
}
