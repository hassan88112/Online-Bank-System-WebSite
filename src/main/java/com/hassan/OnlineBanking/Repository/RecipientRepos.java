package com.hassan.OnlineBanking.Repository;

import com.hassan.OnlineBanking.models.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Author : hassan shalash
 *
 * 21/6/2023
 *
 * */
public interface RecipientRepos extends JpaRepository<Recipient,Long> {

    List<Recipient> findAll();

    Recipient findByName(String recipientName);

    void deleteByName(String recipientName);
}
