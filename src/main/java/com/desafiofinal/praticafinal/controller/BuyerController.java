package com.desafiofinal.praticafinal.controller;

import com.desafiofinal.praticafinal.dto.BuyerDTO;
import com.desafiofinal.praticafinal.model.Buyer;
import com.desafiofinal.praticafinal.service.IBuyerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * This controller holds all endpoints related to Buyer
 * @author Yago
 *
 */
@RestController
@RequestMapping("/api/v1/fresh-products/buyer")
public class BuyerController {

    private final IBuyerService service;
    public BuyerController(IBuyerService service){this.service = service;}

    /**
     * This route insert a new Buyer
     * @param newBuyer A Buyer DTO
     * @return HTML response 201: Created
     */
    @PostMapping("/insert")
    ResponseEntity<BuyerDTO> createBuyer(@RequestBody BuyerDTO newBuyer){
        Buyer buyerEntity = BuyerDTO.convertToEntity(newBuyer);
        Buyer response = service.createBuyer(buyerEntity);
        BuyerDTO responseDTO = new BuyerDTO(response);

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    /**
     * This route returns a list of all created Buyers
     * @return HTML Response 200: Ok
     */
    @GetMapping("/listAll")
    ResponseEntity<List<BuyerDTO>> getAllBuyer(){
        List<Buyer> response = service.getAllBuyer();
        List<BuyerDTO> responseDTO= BuyerDTO.convertListToDTO(response);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    /**
     * This route updates all buyers that reached a threshold for the next avaiable Fidelity level
     * @return HTML Response 202: Accepted
     */
    @PutMapping("/levelUp")
    ResponseEntity<List<BuyerDTO>> levelUpFidelity(){
        List<Buyer> response = service.leveUpFidelity();
        List<BuyerDTO> responseDTO = BuyerDTO.convertListToDTO(response);
        return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
    }

}
