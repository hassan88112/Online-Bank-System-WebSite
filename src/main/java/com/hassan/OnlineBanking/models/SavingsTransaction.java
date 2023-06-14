package com.hassan.OnlineBanking.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Author : hassan shalash
 *
 * 25/5/2023
 *
 * */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavingsTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    private String description;
    private String type;
    private String status;
    private double amount;
    private BigDecimal availableBalance;

    @ManyToOne
    @JoinColumn(name = "savings_account_id")
    private SavingsAccount savingsAccount;

    public SavingsTransaction(Date date,
                              String depositToSavingsAccount,
                              String account,
                              String finished,
                              double amount,
                              BigDecimal accountBalance,
                              SavingsAccount savingsAccount) {
    }
}
