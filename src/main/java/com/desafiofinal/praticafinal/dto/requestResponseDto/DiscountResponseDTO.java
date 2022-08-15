package com.desafiofinal.praticafinal.dto.requestResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscountResponseDTO {

    private double discountedPrice;
    private double realPrice;
}
