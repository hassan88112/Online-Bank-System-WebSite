package com.hassan.OnlineBanking.Service;

import com.hassan.OnlineBanking.models.PrimaryAccount;
import com.hassan.OnlineBanking.models.SavingsAccount;


import java.security.Principal;

public interface AccountService {
	PrimaryAccount createPrimaryAccount();
    SavingsAccount createSavingsAccount();
    void deposit(String accountType, double amount, Principal principal);
    void withdraw(String accountType, double amount, Principal principal);
    
    
}
