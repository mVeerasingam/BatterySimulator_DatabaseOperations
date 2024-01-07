package com.example.batterysimulator_db_operations;

import com.example.batterysimulator_db_operations.POJOs.Simulation;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SimulationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimulationController.class);
    private final SimulationService simulationService;
    private Simulation simulation;

    public SimulationController(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    @GetMapping("getSimulation/{simId}")
    public ResponseEntity<?> getSimulation(@PathVariable String simId) {
        Optional<Simulation> simulation = simulationService.getSimulationBySimId(Long.valueOf(simId));

        if (simulation.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(simulation.get());
    }

    @PostMapping("/createSimulation")
    public ResponseEntity<String>create(@RequestBody String simResults) {

        //System.out.println("\nResults: " + simResults);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // Deserialize the JSON string to JsonNode
            JsonNode jsonNode = objectMapper.readTree(simResults);
            // Convert JsonNode to Simulation object
            simulation = objectMapper.treeToValue(jsonNode, Simulation.class);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\nError while parsing Simulation Results." + simResults);
            return new ResponseEntity<>("Error while parsing Simulation Results", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        simulationService.saveSimulation(simulation);
        LOGGER.info("Simulation created successfully.");
        return new ResponseEntity<>("Simulation created successfully", HttpStatus.OK);
    }
}
