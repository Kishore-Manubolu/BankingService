package com.bs.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Data
@AllArgsConstructor
public class AccountDto {
    private Long accountNo;
    private String accountHolderName;
    private double balance;
    private Long mobile;

}
