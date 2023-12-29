package com.example.batterysimulator_db_operations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SimulationController {

    private final SimulationService simulationService;

    public SimulationController(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    @GetMapping("/{simId}")
    public ResponseEntity<?> getSimulation(@PathVariable String simId) {
        Optional<Simulation> simulation = simulationService.getSimulationBySimId(Long.valueOf(simId));

        if (simulation.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(simulation.get());
    }

    @PostMapping("/createSimulation")
    public ResponseEntity<String>create(@RequestBody Simulation sim) {
        simulationService.saveSimulation(sim);
        return new ResponseEntity<>("Simulation created successfully", HttpStatus.OK);
    }
}
