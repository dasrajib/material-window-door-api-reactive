package com.adu.api.repository;

import com.adu.api.model.MaterialWindowDoor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MaterialWindowDoorRepository extends ReactiveCrudRepository<MaterialWindowDoor, Long> {

    Flux<MaterialWindowDoor> findByColor(String color);    
}
