package com.example.batterysimulator_db_operations.Clients;

import com.example.batterysimulator_db_operations.POJOs.Simulation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimulationRepository extends JpaRepository<Simulation, Long> {
    //Additional custom queries or methods added here if needed
}
