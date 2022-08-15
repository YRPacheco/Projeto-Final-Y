package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.model.Buyer;

import java.util.List;

public interface IBuyerService {

    Buyer createBuyer (Buyer newBuyer);
    List<Buyer> getAllBuyer();

    List<Buyer> leveUpFidelity();
}
