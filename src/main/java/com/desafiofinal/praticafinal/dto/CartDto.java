package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.Buyer;
import com.desafiofinal.praticafinal.model.Cart;
import com.desafiofinal.praticafinal.model.Purchase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {

    private long cartId;

    @NotNull(message = "Please enter a valid buyer")
    private BuyerDTO buyer;

    private Double totalPrice;
    private Double discountedPrice;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @NotNull(message = "Date cannot be null. Format: yyyy/MM/dd")
    private LocalDate date;

    private String orderStatus;

    @NotEmpty(message = "Purchase list cannot be empty")
    private List<@Valid PurchaseDTO> purchaseList;

    public CartDto(Cart cart){
        this.cartId=cart.getCartId();
        this.buyer = new BuyerDTO(cart.getBuyer());
        this.totalPrice=cart.getTotalPrice();
        this.discountedPrice = cart.getDiscountedPrice();
    }

    public static Cart convertDtoToCart (CartDto cartDto){
        Buyer newBuyer = BuyerDTO.convertToEntityOnlyId(cartDto.getBuyer());
        List<Purchase> newPurchase = PurchaseDTO.convertToListEntity(cartDto.getPurchaseList());

        return Cart.builder()
                .cartId(cartDto.getCartId())
                .buyer(newBuyer)
                .date(cartDto.getDate())
                //.totalPrice(cartDto.getTotalPrice())
                //.discountedPrice(cartDto.getDiscountedPrice())
                //.orderStatus(cartDto.getOrderStatus())
                .listPurchase(newPurchase)
                .build();
    }

}
