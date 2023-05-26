package com.hassan.OnlineBanking.Service.Impl;

import com.hassan.OnlineBanking.Repository.UserRepos;
import com.hassan.OnlineBanking.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Author : hassan shalash
 *
 * 25/5/2023
 *
 * */

@Service
public class UserSecurityService implements UserDetailsService {

    /** The application logger */
    private static final Logger LOG = LoggerFactory.getLogger(UserSecurityService.class);

    private final UserRepos userDao;

    public UserSecurityService(UserRepos userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (null == user) {
            LOG.warn("Username {} not found", username);
            throw new UsernameNotFoundException("Username " + username + " not found");
        }
        return user;
    }
}