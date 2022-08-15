package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.model.Fidelity;

import java.util.List;

public interface IFidelityService {

    Fidelity createFidelity (Fidelity newFidelity);
    List<Fidelity> getAllFidelity();
}
