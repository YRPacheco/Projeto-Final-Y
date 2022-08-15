package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.exception.ElementAlreadyExistsException;
import com.desafiofinal.praticafinal.model.Fidelity;
import com.desafiofinal.praticafinal.repository.FidelityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FidelityImpService implements IFidelityService{
    @Autowired
    FidelityRepo repo;

    @Override
    public Fidelity createFidelity(Fidelity newFidelity) {

        Optional<Fidelity> foundFidelity = repo.findById(newFidelity.getFidelityId());

        if (foundFidelity.isPresent()){
            throw new ElementAlreadyExistsException("Esta classe de fidelidade já existe");
        }
        newFidelity.setBuyerList(null);
        return repo.save(newFidelity);
    }

    @Override
    public List<Fidelity> getAllFidelity() {
        return repo.findAll();
    }
}
