package com.hassan.OnlineBanking.Repository;

import com.hassan.OnlineBanking.models.PrimaryTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Author : hassan shalash
 *
 * 19/6/2023
 *
 * */
public interface PrimaryTransactionRepos extends JpaRepository<PrimaryTransaction,Long> {

    List<PrimaryTransaction> findAll();
}
