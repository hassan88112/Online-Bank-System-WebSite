package com.hassan.OnlineBanking.Service.Impl;

import com.hassan.OnlineBanking.Repository.UserRepos;
import com.hassan.OnlineBanking.Service.UserService;
import com.hassan.OnlineBanking.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserRepos  userRepos;


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

}
