package com.lisseth.demo.digitalwalletapi.dto.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequestDTO {

    @NotBlank(message = "Document Number is mandatory")
    private String documentNumber;

    @NotBlank(message = "Phone Number is mandatory")
    @Size(min = 10)
    private String phoneNumber;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Email is mandatory")
    private String email;
}
