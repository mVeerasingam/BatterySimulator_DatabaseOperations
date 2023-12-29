package com.example.batterysimulator_db_operations;

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

    public Optional<Simulation> getSimulationBySimId(String simId) {
        return simulationRepo.findById(Long.valueOf(simId));
    }
}
