package com.example.batterysimulator_db_operations.Clients;

import com.example.batterysimulator_db_operations.POJOs.SimulationResults;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimulationResultRepository extends JpaRepository<SimulationResults, Long> {
    //Additional custom queries or methods added here if needed
}
