package com.example.awsdemo.repositories;

import com.example.awsdemo.models.Instance;
import org.springframework.data.repository.CrudRepository;

public interface InstanceRepository extends CrudRepository<Instance, String> {
}
