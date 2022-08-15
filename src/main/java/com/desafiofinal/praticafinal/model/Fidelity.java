package com.desafiofinal.praticafinal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fidelity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long fidelityId;
    private boolean freeShipping;
    private String fidelityClass;
    private Double discount;
    private Double levelUpThreshold;

    @OneToMany(mappedBy = "fidelity")
    private List<Buyer> buyerList;

}
