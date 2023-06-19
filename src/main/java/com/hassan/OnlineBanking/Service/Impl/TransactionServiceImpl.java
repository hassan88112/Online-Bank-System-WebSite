package com.hassan.OnlineBanking.Service.Impl;

import com.hassan.OnlineBanking.Repository.PrimaryAccountRepo;
import com.hassan.OnlineBanking.Repository.PrimaryTransactionRepos;
import com.hassan.OnlineBanking.Repository.SavingAccountRepo;
import com.hassan.OnlineBanking.Repository.SavingsTransactionRepos;
import com.hassan.OnlineBanking.Service.TransactionService;
import com.hassan.OnlineBanking.Service.UserService;
import com.hassan.OnlineBanking.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Author : hassan shalash
 *
 * 14/6/2023
 *
 * */

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private UserService userService;

    @Autowired
    private PrimaryTransactionRepos primaryTransactionRepos;

    @Autowired
    private SavingsTransactionRepos savingsTransactionRepos;
    @Autowired
    private PrimaryAccountRepo primaryAccountRepo;
    @Autowired
    private SavingAccountRepo savingAccountRepo;


    @Override
    public List<PrimaryTransaction> findPrimaryTransactionList(String username) {
        User user=userService.findByUsername(username);
        List<PrimaryTransaction> primaryTransactionList=user.getPrimaryAccount().getPrimaryTransactionList();

        return primaryTransactionList;
    }

    @Override
    public List<SavingsTransaction> findSavingsTransactionList(String username) {
        User user=userService.findByUsername(username);
        List<SavingsTransaction> savingsTransactionList=user.getSavingsAccount().getSavingsTransactionList();

        return savingsTransactionList;
    }

    @Override
    public void savePrimaryDepositTransaction(PrimaryTransaction primaryTransaction) {

        primaryTransactionRepos.save(primaryTransaction);
    }

    @Override
    public void saveSavingsDepositTransaction(SavingsTransaction savingsTransaction) {

        savingsTransactionRepos.save(savingsTransaction);
    }

    @Override
    public void savePrimaryWithdrawTransaction(PrimaryTransaction primaryTransaction) {

        primaryTransactionRepos.save(primaryTransaction);
    }

    @Override
    public void saveSavingsWithdrawTransaction(SavingsTransaction savingsTransaction) {

        savingsTransactionRepos.save(savingsTransaction);
    }

    // TODO transfer Money between Accounts (Primary ,Savings) with >> Hassan Shalash ##
    @Override
    public void betweenAccountsTransfer(String transferFrom, String transferTo, String amount, PrimaryAccount primaryAccount, SavingsAccount savingsAccount) throws Exception {
        if (transferFrom.equalsIgnoreCase("Primary") && transferTo.equalsIgnoreCase("Savings")){
            primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().subtract(new BigDecimal(amount)));
            savingsAccount.setAccountBalance(savingsAccount.getAccountBalance().add(new BigDecimal(amount)));

            primaryAccountRepo.save(primaryAccount);
            savingAccountRepo.save(savingsAccount);

            Date date=new Date();
            PrimaryTransaction primaryTransaction=new PrimaryTransaction(date,"Between account transfer from"+transferFrom +"to"+transferTo,"Account","Finished",Double.parseDouble(amount),primaryAccount.getAccountBalance(),primaryAccount);
            primaryTransactionRepos.save(primaryTransaction);

        } else if (transferFrom.equalsIgnoreCase("Savings") && transferTo.equalsIgnoreCase("Primary")) {
            savingsAccount.setAccountBalance(savingsAccount.getAccountBalance().subtract(new BigDecimal(amount)));
            primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().add(new BigDecimal(amount)));

            savingAccountRepo.save(savingsAccount);
            primaryAccountRepo.save(primaryAccount);

            Date date=new Date();
            SavingsTransaction savingsTransaction=new SavingsTransaction(date,"Between account transfer from"+transferFrom +"to"+transferTo,"Account","Finished",Double.parseDouble(amount),savingsAccount.getAccountBalance(),savingsAccount);
            savingsTransactionRepos.save(savingsTransaction);
        }else {
            throw new Exception("Invalid Transfer");
        }
    }
}
