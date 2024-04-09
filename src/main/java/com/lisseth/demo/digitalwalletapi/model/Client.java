package com.lisseth.demo.digitalwalletapi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client {

    @Id
    private String documentNumber;

    private String phoneNumber;

    private String name;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wallet_id", referencedColumnName = "id")
    private Wallet wallet;
    public Client(String documentNumber, String phoneNumber, String name, String email) {
        this.documentNumber = documentNumber;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.email = email;
        this.wallet = new Wallet();
    }
}