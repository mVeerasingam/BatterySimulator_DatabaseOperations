package com.example.batterysimulator_db_operations;

import com.example.batterysimulator_db_operations.POJOs.Simulation;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SimulationController {

    private final SimulationService simulationService;
    private Simulation simulation;

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
    public ResponseEntity<String>create(@RequestBody String simResults) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // Deserialize the JSON string to JsonNode
            JsonNode jsonNode = objectMapper.readTree(simResults);
            // Convert JsonNode to Simulation object
            simulation = objectMapper.treeToValue(jsonNode, Simulation.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        simulationService.saveSimulation(simulation);
        return new ResponseEntity<>("Simulation created successfully", HttpStatus.OK);
    }
}
