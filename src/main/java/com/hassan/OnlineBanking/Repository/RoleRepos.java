package com.hassan.OnlineBanking.Repository;

import com.hassan.OnlineBanking.models.Security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepos extends JpaRepository<Role,Integer> {

    Role findByName(String name);
}
