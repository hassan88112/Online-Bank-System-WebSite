package com.hassan.OnlineBanking.Repository;

import com.hassan.OnlineBanking.models.SavingsTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Author : hassan shalash
 *
 * 19/6/2023
 *
 * */
public interface SavingsTransactionRepos extends JpaRepository<SavingsTransaction,Long> {

    List<SavingsTransaction> findAll();
}
