package com.hassan.OnlineBanking.Service.Impl;

import com.hassan.OnlineBanking.Repository.RoleRepos;
import com.hassan.OnlineBanking.Repository.UserRepos;
import com.hassan.OnlineBanking.Service.AccountService;
import com.hassan.OnlineBanking.Service.UserService;
import com.hassan.OnlineBanking.models.Security.UserRole;
import com.hassan.OnlineBanking.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

/**
 * Author : hassan shalash
 *
 * 25/5/2023
 *
 * */
@Service
@Transactional
public class UserServiceImpl  implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepos  userRepos;

    @Autowired
    private RoleRepos roleRepos;

    @Autowired
    private AccountService accountService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    public void save(User user) {
        userRepos.save(user);
    }

    public User findByUsername(String username) {
        return userRepos.findByUsername(username);
    }

    public User findByEmail(String email) {
        return userRepos.findByEmail(email);
    }





    public boolean checkUserExists(String username, String email){
        if (checkUsernameExists(username) || checkEmailExists(email)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkUsernameExists(String username) {
        if (findByUsername(username) != null  ) {
            return true;
        }

        return false;
    }

    public boolean checkEmailExists(String email) {
        if (findByEmail(email) != null  ) {
            return true;
        }

        return false;
    }

    public User createUser(User user, Set<UserRole> userRoles) {
        User localUser = userRepos.findByUsername(user.getUsername());

        if (localUser != null) {
            LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
        } else {
            localUser=new User();
            String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
            user.setPassword(encryptedPassword);

            for (UserRole ur : userRoles) {
                roleRepos.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);

            user.setPrimaryAccount(accountService.createPrimaryAccount());
            user.setSavingsAccount(accountService.createSavingsAccount());

            localUser = userRepos.saveAndFlush(user);
        }

        return localUser;
    }

}
