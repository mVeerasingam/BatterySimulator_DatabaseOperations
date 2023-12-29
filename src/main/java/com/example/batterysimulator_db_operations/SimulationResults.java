package com.example.batterysimulator_db_operations;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimulationResults {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long simResultsId;

    @ManyToOne
    @JoinColumn(name = "simulation_simId")
    private Simulation simulation;

    private Double current;
    private Double dcap;
    private Double time;
    private Double voltage;
}