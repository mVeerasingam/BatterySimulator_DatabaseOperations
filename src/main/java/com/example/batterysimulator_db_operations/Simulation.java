package com.example.batterysimulator_db_operations;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Simulation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long simId;

    @Enumerated(EnumType.STRING)
    private SimulationType simulationType;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "simulation_simId")
    private List<SimulationResults> simulationResults;
}
