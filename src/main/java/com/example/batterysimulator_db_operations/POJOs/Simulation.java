package com.example.batterysimulator_db_operations.POJOs;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference
    private List<SimulationResults> simulationResults;

    @Column(nullable = true)
    private double time;
    @Column(nullable = true)
    private double upperVoltage;
    @Column(nullable = true)
    private double lowerVoltage;
    @Column(nullable = true)
    private double nominalCell;
    @Column(nullable = true)
    private double controlCurrent;
}
