package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.Fidelity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FidelityDTO {

    private long fidelityId;
    private boolean freeShipping;
    private String fidelityClass;
    private Double discount;
    private Double levelUpThreshold;


    public FidelityDTO(Fidelity fidelityEntity){
        this.fidelityClass = fidelityEntity.getFidelityClass();
        this.freeShipping = fidelityEntity.isFreeShipping();
        this.fidelityId = fidelityEntity.getFidelityId();
        this.discount = fidelityEntity.getDiscount();
        this.levelUpThreshold = fidelityEntity.getLevelUpThreshold();
    }

    public static Fidelity convertToEntity (FidelityDTO dto){
        return Fidelity.builder()
                .fidelityId(dto.getFidelityId())
                //.freeShipping(dto.isFreeShipping())
                //.fidelityClass(dto.getFidelityClass())
                //.discount(dto.discount)
                //.levelUpThreshold(dto.getLevelUpThreshold())
                .build();
    }

    public static List<Fidelity> convertToListEntity(List<FidelityDTO> DTOList){
            return DTOList.stream()
                    .map(FidelityDTO::convertToEntity)
                    .collect(Collectors.toList());
        }
    public static List<FidelityDTO> convertListToDTO(List<Fidelity> list){
            return list.stream()
                    .map(FidelityDTO::new)
                    .collect(Collectors.toList());
        }
}
