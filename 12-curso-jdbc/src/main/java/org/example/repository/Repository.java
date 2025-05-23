package org.example.repository;

import java.util.List;

public interface Repository <T>{
    List<T> findAll() throws Exception;
    T findById(Integer id);
    void save(T t);
    void delete(Integer id);
}
