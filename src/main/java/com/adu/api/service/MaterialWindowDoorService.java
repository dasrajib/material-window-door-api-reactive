package com.adu.api.service;

import com.adu.api.model.MaterialWindowDoor;
import com.adu.api.repository.MaterialWindowDoorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MaterialWindowDoorService {

    private final MaterialWindowDoorRepository materialwindowdoorRepository;

    public Flux<MaterialWindowDoor> getAllMaterialWindowDoor() {
        return materialwindowdoorRepository.findAll();
    }

    public Mono<MaterialWindowDoor> getMaterialWindowDoorById(Long materialwindowdoor_id) {
        return materialwindowdoorRepository.findById(materialwindowdoor_id);
    }

    public Mono<MaterialWindowDoor> createMaterialWindowDoor(MaterialWindowDoor materialwindowdoor) {
        return materialwindowdoorRepository.save(materialwindowdoor);
    }

    public Mono<MaterialWindowDoor> updateMaterialWindowDoor(Long materialwindowdoor_id, MaterialWindowDoor materialwindowdoor) {
        return materialwindowdoorRepository.findById(materialwindowdoor_id)
                .flatMap(existingMaterialWindowDoor -> {
                    existingMaterialWindowDoor.setDescription(materialwindowdoor.getDescription());
                    existingMaterialWindowDoor.setExt_description(materialwindowdoor.getExt_description());
                    existingMaterialWindowDoor.setType(materialwindowdoor.getType());
                    existingMaterialWindowDoor.setColor(materialwindowdoor.getColor());
                    existingMaterialWindowDoor.setPrice(materialwindowdoor.getPrice());

                    existingMaterialWindowDoor.setUpdated_at(LocalDateTime.now());
                
                    return materialwindowdoorRepository.save(existingMaterialWindowDoor);
                });
    }

    public Mono<Void> deleteMaterialWindowDoor(Long materialwindowdoor_id) {
        return materialwindowdoorRepository.deleteById(materialwindowdoor_id);
    }
}
