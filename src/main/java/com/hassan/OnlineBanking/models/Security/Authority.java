package com.hassan.OnlineBanking.models.Security;

import org.springframework.security.core.GrantedAuthority;
/**
 * Author : hassan shalash
 *
 * 25/5/2023
 *
 * */
public class Authority implements GrantedAuthority{

    private final String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
