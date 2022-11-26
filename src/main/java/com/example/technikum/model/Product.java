package com.example.technikum.model;

import lombok.*;
import javax.persistence.*;
import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "balance")
    private BigInteger balance;

    @Column(name = "productCode")
    private String productCode;

    @Column(name = "interestRate")
    private BigInteger interestRate;

}
