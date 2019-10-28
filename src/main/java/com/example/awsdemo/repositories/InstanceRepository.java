package com.example.awsdemo.repositories;

import com.example.awsdemo.models.Instance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstanceRepository extends CrudRepository<Instance, String> {
}
