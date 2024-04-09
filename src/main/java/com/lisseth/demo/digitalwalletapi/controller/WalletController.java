package com.lisseth.demo.digitalwalletapi.controller;

import com.lisseth.demo.digitalwalletapi.dto.wallet.WalletRequestDTO;
import com.lisseth.demo.digitalwalletapi.exception.WalletException;
import com.lisseth.demo.digitalwalletapi.service.WalletService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @PostMapping("/recharge")
    public ResponseEntity<?> walletRecharge(
            @Valid @RequestBody WalletRequestDTO request
            ){
        try{
            return ResponseEntity.ok(walletService.recharge(request));
        }catch (WalletException e){
            return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
        }

    }


    @GetMapping("/balance")
    public ResponseEntity<?> walletBalance(
            @RequestParam @NotBlank(message = "Document Number is mandatory") String documentNumber,
            @RequestParam @NotBlank(message = "Phone Number is mandatory") @Size(min = 10)String phoneNumber
    ){
        try{
            return ResponseEntity.ok(walletService.balance(documentNumber, phoneNumber));
        }catch (WalletException e){
            return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
        }

    }

}
