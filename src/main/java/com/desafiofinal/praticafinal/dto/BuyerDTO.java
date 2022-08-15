package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.Buyer;
import com.desafiofinal.praticafinal.model.Fidelity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyerDTO {

    private long buyerId;

    private String buyerName;
    private FidelityDTO fidelity;
    private Double score;

    public BuyerDTO(Buyer buyer){

        this.buyerId= buyer.getBuyerId();
        this.buyerName = buyer.getBuyerName();
        this.fidelity = new FidelityDTO(buyer.getFidelity());
        this.score = buyer.getScore();
    }

    public static Buyer convertToEntity (BuyerDTO dto){

        Fidelity newFidelity = FidelityDTO.convertToEntity(dto.getFidelity());
        return Buyer.builder()
                //.buyerName(dto.getBuyerName())
                .buyerId(dto.getBuyerId())
                .fidelity(newFidelity)
                //.score(dto.getScore())
                .build();
    }


    public static List<Buyer> convertToListEntity (List<BuyerDTO> DTOList){
        return  DTOList.stream()
                .map(BuyerDTO::convertToEntity)
                .collect(Collectors.toList());
    }
    public static List<BuyerDTO> convertListToDTO(List<Buyer> list){
        return list.stream()
                .map(BuyerDTO::new)
                .collect(Collectors.toList());
    }

}
