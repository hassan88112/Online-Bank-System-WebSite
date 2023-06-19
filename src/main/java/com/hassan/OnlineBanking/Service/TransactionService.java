package com.hassan.OnlineBanking.Service;

import com.hassan.OnlineBanking.models.PrimaryAccount;
import com.hassan.OnlineBanking.models.PrimaryTransaction;
import com.hassan.OnlineBanking.models.SavingsAccount;
import com.hassan.OnlineBanking.models.SavingsTransaction;

import java.util.List;

/**
 * Author : hassan shalash
 *
 * 14/6/2023
 *
 * */

public interface TransactionService {
    List<PrimaryTransaction> findPrimaryTransactionList(String username);

    List<SavingsTransaction> findSavingsTransactionList(String username);

    void savePrimaryDepositTransaction(PrimaryTransaction primaryTransaction);

    void saveSavingsDepositTransaction(SavingsTransaction savingsTransaction);

    void savePrimaryWithdrawTransaction(PrimaryTransaction primaryTransaction);
    void saveSavingsWithdrawTransaction(SavingsTransaction savingsTransaction);
    void betweenAccountsTransfer(String transferFrom, String transferTo, String amount, PrimaryAccount primaryAccount, SavingsAccount savingsAccount) throws Exception;


}
