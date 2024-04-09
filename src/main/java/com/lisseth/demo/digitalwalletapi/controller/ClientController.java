package com.lisseth.demo.digitalwalletapi.controller;

import com.lisseth.demo.digitalwalletapi.dto.client.RegisterRequestDTO;
import com.lisseth.demo.digitalwalletapi.exception.RegisterException;
import com.lisseth.demo.digitalwalletapi.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/register")
    public ResponseEntity<?> clientRegister(
            @Valid @RequestBody RegisterRequestDTO request
            ){
        try{
            return ResponseEntity.ok(clientService.registerClient(request));
        } catch (RegisterException e){
            return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
        }


    }
}
