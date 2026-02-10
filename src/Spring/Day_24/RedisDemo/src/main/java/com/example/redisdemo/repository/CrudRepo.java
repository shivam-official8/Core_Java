package com.example.redisdemo.repository;

import com.example.redisdemo.model.CrudModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudRepo extends CrudRepository<CrudModel, Long> {
}
