package com.desafiofinal.praticafinal.controller;

import com.desafiofinal.praticafinal.dto.BuyerDTO;
import com.desafiofinal.praticafinal.model.Buyer;
import com.desafiofinal.praticafinal.service.IBuyerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products/buyer")
public class BuyerController {

    private final IBuyerService service;
    public BuyerController(IBuyerService service){this.service = service;}


    @PostMapping("/insert")
    ResponseEntity<BuyerDTO> createBuyer(@RequestBody BuyerDTO newBuyer){
        Buyer buyerEntity = BuyerDTO.convertToEntity(newBuyer);
        Buyer response = service.createBuyer(buyerEntity);
        BuyerDTO responseDTO = new BuyerDTO(response);

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/listAll")
    ResponseEntity<List<BuyerDTO>> getAllBuyer(){
        List<Buyer> response = service.getAllBuyer();
        List<BuyerDTO> responseDTO= BuyerDTO.convertListToDTO(response);
        return new ResponseEntity<>(responseDTO,HttpStatus.ACCEPTED);
    }

    @GetMapping("/levelUp")
    ResponseEntity<List<BuyerDTO>> levelUpFidelity(){
        List<Buyer> response = service.leveUpFidelity();
        List<BuyerDTO> responseDTO = BuyerDTO.convertListToDTO(response);
        return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
    }

}
