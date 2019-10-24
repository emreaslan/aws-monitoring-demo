package com.example.awsdemo.services;

import java.util.List;
import java.util.Optional;

public interface SimpleService<T, I> {
    Optional<T> getInstanceById(I id);
    void save (T instance);
    List<T> getInstancesList();
}
