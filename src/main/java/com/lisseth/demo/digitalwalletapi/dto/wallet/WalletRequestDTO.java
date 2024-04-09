package com.lisseth.demo.digitalwalletapi.dto.wallet;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class WalletRequestDTO {

    @NotBlank(message = "Document Number is mandatory")
    private String documentNumber;

    @NotBlank(message = "Phone Number is mandatory")
    @Size(min = 10)
    private String phoneNumber;

    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal rechargeValue;
}
