package com.hassan.OnlineBanking.Repository;

import com.hassan.OnlineBanking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepos extends JpaRepository<User,Long> {

    User findByUsername(String username);
    User findByEmail(String email);
}
