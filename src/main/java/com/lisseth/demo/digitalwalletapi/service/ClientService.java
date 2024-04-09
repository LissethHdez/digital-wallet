package com.lisseth.demo.digitalwalletapi.service;

import com.lisseth.demo.digitalwalletapi.dto.client.RegisterRequestDTO;
import com.lisseth.demo.digitalwalletapi.exception.RegisterException;
import com.lisseth.demo.digitalwalletapi.model.Client;
import com.lisseth.demo.digitalwalletapi.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Client registerClient(RegisterRequestDTO request) throws RegisterException {

        if(clientRepository.existsById(request.getDocumentNumber())){
            throw new RegisterException("User already exists", HttpStatus.CONFLICT.value());
        }

        Client client = new Client(request.getDocumentNumber(), request.getPhoneNumber(),request.getName() , request.getEmail());

        return clientRepository.save(client);

    }
}
