package com.hassan.OnlineBanking.Service.Impl;

import com.hassan.OnlineBanking.Repository.PrimaryAccountRepo;
import com.hassan.OnlineBanking.Repository.SavingAccountRepo;
import com.hassan.OnlineBanking.Service.AccountService;
import com.hassan.OnlineBanking.models.PrimaryAccount;
import com.hassan.OnlineBanking.models.SavingsAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private PrimaryAccountRepo primaryAccountRepo;

    @Autowired
    private SavingAccountRepo savingAccountRepo;

    private static int nextAccountNumber = 11223145;


    public PrimaryAccount createPrimaryAccount() {
        PrimaryAccount primaryAccount = new PrimaryAccount();
        primaryAccount.setAccountBalance(new BigDecimal(0.0));
        primaryAccount.setAccountNumber(accountGen());

        primaryAccountRepo.save(primaryAccount);

        return primaryAccountRepo.findByAccountNumber(primaryAccount.getAccountNumber());
    }

    public SavingsAccount createSavingsAccount() {
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setAccountBalance(new BigDecimal(0.0));
        savingsAccount.setAccountNumber(accountGen());

        savingAccountRepo.save(savingsAccount);

        return savingAccountRepo.findByAccountNumber(savingsAccount.getAccountNumber());
    }
    @Override
    public void deposit(String accountType, double amount, Principal principal) {

    }

    @Override
    public void withdraw(String accountType, double amount, Principal principal) {

    }

    private int accountGen() {
        return ++nextAccountNumber;
    }
}
