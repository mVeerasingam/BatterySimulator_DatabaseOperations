package com.example.batterysimulator_db_operations;

import com.example.batterysimulator_db_operations.Clients.SimulationRepository;
import com.example.batterysimulator_db_operations.POJOs.Simulation;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SimulationService {

    private final SimulationRepository simulationRepo;

    public SimulationService(SimulationRepository simulationRepo) {
        this.simulationRepo = simulationRepo;
    }

    //Save a simulation
    public void saveSimulation(Simulation sim) {
        simulationRepo.save(sim);
    }

    public Optional<Simulation> getSimulationBySimId(Long simId) {
        return simulationRepo.findById(simId);
    }
}
