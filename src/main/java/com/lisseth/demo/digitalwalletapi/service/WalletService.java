package com.lisseth.demo.digitalwalletapi.service;

import com.lisseth.demo.digitalwalletapi.dto.wallet.WalletRequestDTO;
import com.lisseth.demo.digitalwalletapi.exception.RegisterException;
import com.lisseth.demo.digitalwalletapi.exception.WalletException;
import com.lisseth.demo.digitalwalletapi.model.Client;
import com.lisseth.demo.digitalwalletapi.model.Wallet;
import com.lisseth.demo.digitalwalletapi.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final ClientRepository clientRepository;

    public Client recharge(WalletRequestDTO request) throws WalletException {

        Client client = getClient(request.getDocumentNumber(), request.getPhoneNumber());

        Wallet wallet = client.getWallet();

        wallet.setCurrentValue(wallet.getCurrentValue().add(request.getRechargeValue()));

        return clientRepository.save(client);

    }

    public BigDecimal balance(String documentNumber, String phoneNumber) throws WalletException {

        Client client = getClient(documentNumber, phoneNumber);

        return client.getWallet().getCurrentValue();
    }

    private Client getClient(String documentNumber, String phoneNumber){
        Optional<Client> client = clientRepository.findByDocumentNumberAndPhoneNumber(documentNumber, phoneNumber);

        if(client.isEmpty()){
            throw new RegisterException("User not found", HttpStatus.NOT_FOUND.value());
        }

        return client.get();
    }
}
