package com.desafiofinal.praticafinal.controller;

import com.desafiofinal.praticafinal.dto.FidelityDTO;
import com.desafiofinal.praticafinal.model.Fidelity;
import com.desafiofinal.praticafinal.service.IFidelityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products/fidelity")
public class FidelityController {

    private final IFidelityService service;
    public FidelityController(IFidelityService service){this.service = service;}

    @PostMapping("/insert")
    ResponseEntity<FidelityDTO> createFidelity(@RequestBody FidelityDTO newFidelity){

        Fidelity fidelityEntity = FidelityDTO.convertToEntity(newFidelity);
        Fidelity response = service.createFidelity(fidelityEntity);
        FidelityDTO responseDTO = new FidelityDTO(response);

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    @GetMapping("/listAll")
    ResponseEntity<List<FidelityDTO>> getAllFidelity(){

        List<Fidelity> response = service.getAllFidelity();
        List<FidelityDTO> responseDTO = FidelityDTO.convertListToDTO(response);
        return new ResponseEntity<>(responseDTO,HttpStatus.ACCEPTED);
    }


}
