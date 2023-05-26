package com.hassan.OnlineBanking.Service;

import com.hassan.OnlineBanking.models.Security.UserRole;
import com.hassan.OnlineBanking.models.User;

import java.util.Set;

public interface UserService {

    User findByUsername(String username);

    User findByEmail(String email);

    boolean checkUserExists(String username, String email);

    boolean checkUsernameExists(String username);

    boolean checkEmailExists(String email);

    void save (User user);

    User createUser(User user, Set<UserRole> userRoles);
}
