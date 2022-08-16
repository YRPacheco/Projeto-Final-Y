package com.desafiofinal.praticafinal.controller;

import com.desafiofinal.praticafinal.dto.FidelityDTO;
import com.desafiofinal.praticafinal.model.Fidelity;
import com.desafiofinal.praticafinal.service.IFidelityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This controller holds all endpoints related to Fidelities
 * @author Yago
 *
 */

@RestController
@RequestMapping("/api/v1/fresh-products/fidelity")
public class FidelityController {

    private final IFidelityService service;
    public FidelityController(IFidelityService service){this.service = service;}

    /**
     * This route insert a new Fidelity
     * @param newFidelity A Fidelity DTO
     * @return HTML response 201: Created
     */
    @PostMapping("/insert")
    ResponseEntity<FidelityDTO> createFidelity(@RequestBody FidelityDTO newFidelity){

        Fidelity fidelityEntity = FidelityDTO.convertToEntity(newFidelity);
        Fidelity response = service.createFidelity(fidelityEntity);
        FidelityDTO responseDTO = new FidelityDTO(response);

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    /**
     * This route returns a list of all created Fidelity classes
     * @return HTML Response 200: Ok
     */
    @GetMapping("/listAll")
    ResponseEntity<List<FidelityDTO>> getAllFidelity(){

        List<Fidelity> response = service.getAllFidelity();
        List<FidelityDTO> responseDTO = FidelityDTO.convertListToDTO(response);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }


}
