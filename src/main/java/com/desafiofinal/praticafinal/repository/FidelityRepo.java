package com.desafiofinal.praticafinal.repository;

import com.desafiofinal.praticafinal.model.Fidelity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FidelityRepo extends JpaRepository<Fidelity,Long> {
}
