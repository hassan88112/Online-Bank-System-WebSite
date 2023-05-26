package com.hassan.OnlineBanking.Controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    @GetMapping("/primaryAccount")
    public String primaryAccount(){
        return "primaryAccount";
    }

    @GetMapping("/savingsAccount")
    public String SavingsAccount(){
        return "savingsAccount";
    }
}
