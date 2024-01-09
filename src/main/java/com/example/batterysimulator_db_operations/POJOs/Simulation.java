package com.example.batterysimulator_db_operations.POJOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private Long id;

    @Enumerated(EnumType.STRING)
    private SimulationType simulationType;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "simulation_id")
    @JsonManagedReference
    private List<SimulationResults> simulationResults;
    @Column(nullable = true)
    private String jobStarted;
}
