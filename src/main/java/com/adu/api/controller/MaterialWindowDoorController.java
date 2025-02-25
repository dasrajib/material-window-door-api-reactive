package com.adu.api.controller;

import com.adu.api.model.MaterialWindowDoor;
import com.adu.api.service.MaterialWindowDoorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/materialwindowdoor")
@RequiredArgsConstructor
@Tag(name = "Window Door Material Management", description = "APIs for managing window door material")
public class MaterialWindowDoorController {

    private final MaterialWindowDoorService materialwindowdoorService;

    @GetMapping
    @Operation(summary = "Get all window door material")
    public Flux<MaterialWindowDoor> getAllMaterialWindowDoor() {
        return materialwindowdoorService.getAllMaterialWindowDoor();
    }

    @GetMapping("/{materialwindowdoor_id}")
    @Operation(summary = "Get materialwindowdoor by ID")
    public Mono<MaterialWindowDoor> getMaterialWindowDoorById(@PathVariable Long materialwindowdoor_id) {
        return materialwindowdoorService.getMaterialWindowDoorById(materialwindowdoor_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new materialwindowdoor")
    public Mono<MaterialWindowDoor> createMaterialWindowDoor(@RequestBody MaterialWindowDoor materialwindowdoor) {
        return materialwindowdoorService.createMaterialWindowDoor(materialwindowdoor);
    }

    @PutMapping("/{materialwindowdoor_id}")
    @Operation(summary = "Update an existing materialwindowdoor")
    public Mono<MaterialWindowDoor> updateMaterialWindowDoor(@PathVariable Long materialwindowdoor_id, @RequestBody MaterialWindowDoor materialwindowdoor) {
        return materialwindowdoorService.updateMaterialWindowDoor(materialwindowdoor_id, materialwindowdoor);
    }

    @DeleteMapping("/{materialwindowdoor_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a materialwindowdoor")
    public Mono<Void> deleteMaterialWindowDoor(@PathVariable Long materialwindowdoor_id) {
        return materialwindowdoorService.deleteMaterialWindowDoor(materialwindowdoor_id);
    }
}
