package com.bs.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNo;

    @Column(name="account_holder_name")
    private String accountHolderName;
    private double balance;
    private Long mobile;

}
