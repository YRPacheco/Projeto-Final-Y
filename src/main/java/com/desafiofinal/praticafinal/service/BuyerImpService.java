package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.exception.ElementAlreadyExistsException;
import com.desafiofinal.praticafinal.model.Buyer;
import com.desafiofinal.praticafinal.model.Fidelity;
import com.desafiofinal.praticafinal.repository.BuyerRepo;
import com.desafiofinal.praticafinal.repository.FidelityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BuyerImpService implements IBuyerService{

    @Autowired
    BuyerRepo repo;

    @Autowired
    FidelityRepo fidelityRepo;

    @Override
    public Buyer createBuyer(Buyer newBuyer) {
        Optional<Buyer> foundBuyer = repo.findById(newBuyer.getBuyerId());

            if (foundBuyer.isPresent()){
                throw new ElementAlreadyExistsException("Este comprador já existe");
            }

            Optional<Fidelity> foundFidelity = fidelityRepo.findById(newBuyer.getFidelity().getFidelityId());


            newBuyer.setCartList(null);

            newBuyer.setFidelity(foundFidelity.get());

            return repo.save(newBuyer);
    }

    @Override
    public List<Buyer> getAllBuyer() {
        return repo.findAll();
    }

    @Override
    public List<Buyer> leveUpFidelity() {
        return null;
    }
}
