package com.hassan.OnlineBanking.Repository;

import com.hassan.OnlineBanking.models.PrimaryAccount;
import com.hassan.OnlineBanking.models.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingAccountRepo extends JpaRepository<SavingsAccount,Long> {

    SavingsAccount findByAccountNumber (int accountNumber);
}
