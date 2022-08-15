package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.exception.ElementAlreadyExistsException;
import com.desafiofinal.praticafinal.exception.ElementNotFoundException;
import com.desafiofinal.praticafinal.model.Buyer;
import com.desafiofinal.praticafinal.model.Fidelity;
import com.desafiofinal.praticafinal.repository.BuyerRepo;
import com.desafiofinal.praticafinal.repository.FidelityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class BuyerImpService implements IBuyerService{

    @Autowired
    BuyerRepo buyerRepo;

    @Autowired
    FidelityRepo fidelityRepo;

    @Override
    public Buyer createBuyer(Buyer newBuyer) {
        Optional<Buyer> foundBuyer = buyerRepo.findById(newBuyer.getBuyerId());

            if (foundBuyer.isPresent()){
                throw new ElementAlreadyExistsException("Este comprador já existe");
            }

            Optional<Fidelity> foundFidelity = fidelityRepo.findById(newBuyer.getFidelity().getFidelityId());


            newBuyer.setCartList(null);

            newBuyer.setFidelity(foundFidelity.get());

            return buyerRepo.save(newBuyer);
    }

    @Override
    public List<Buyer> getAllBuyer() {

        return buyerRepo.findAll();
    }

    @Override
    public List<Buyer> leveUpFidelity() {

        List<Buyer> buyerList = buyerRepo.findAll();
        List<Buyer> response = null;

        if(buyerList.isEmpty()){
            throw new ElementNotFoundException("Nenhum comprador encontrado");
        }

        response = getUpdatedFidelityList(buyerList);

        for (Buyer responseBuyer : response){
            buyerRepo.save(responseBuyer);
        }

        return response;
    }

    private List<Buyer> getUpdatedFidelityList(List<Buyer> buyerList) {
        List<Fidelity> fidelityClasses = fidelityRepo.findAll();
        List<Buyer> response = new ArrayList<>();
        Fidelity tempFidelity = null;
        int change = 0;

        for (Buyer buyer : buyerList)
        {
            tempFidelity = buyer.getFidelity();
            for (Fidelity fidelity: fidelityClasses){
                if (buyer.getScore()>= fidelity.getLevelUpThreshold())
                {
                    tempFidelity = fidelity;
                    change++;
                }
            }
            if (!response.contains(buyer) && change !=0)
            {
                buyer.setFidelity(tempFidelity);
                response.add(buyer);
                change =0;
            }
        }
        return response;
    }
}
