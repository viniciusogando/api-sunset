package com.vinicius.store.repository;

import com.vinicius.store.model.Sunset;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SunsetRepository extends MongoRepository<Sunset, String> {

}
