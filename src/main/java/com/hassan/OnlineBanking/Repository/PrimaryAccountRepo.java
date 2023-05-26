package com.hassan.OnlineBanking.Repository;

import com.hassan.OnlineBanking.models.PrimaryAccount;
import com.hassan.OnlineBanking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryAccountRepo extends JpaRepository<PrimaryAccount,Long> {



    PrimaryAccount findByAccountNumber (int accountNumber);
}
