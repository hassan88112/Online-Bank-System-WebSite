package com.hassan.OnlineBanking.Controller;

import com.hassan.OnlineBanking.Service.AccountService;
import com.hassan.OnlineBanking.Service.UserService;
import com.hassan.OnlineBanking.models.PrimaryAccount;
import com.hassan.OnlineBanking.models.PrimaryTransaction;
import com.hassan.OnlineBanking.models.SavingsAccount;
import com.hassan.OnlineBanking.models.User;
import org.omg.IOP.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

/**
 * Author : hassan shalash
 *
 * 26/5/2023
 *
 * */
@Controller
@RequestMapping("/account")
public class AccountController {

    Logger logger=LoggerFactory.getLogger(AccountController.class);


    @Autowired
    private UserService userService;


    @GetMapping("/primaryAccount")
    public String primaryAccount(Model model,Principal principal){
        // TODO hat el primaryAccount bta3 user el 3ml sign in  >>   created by hassan shalash
        User user=userService.findByUsername(principal.getName());
        PrimaryAccount primaryAccount=user.getPrimaryAccount();
        logger.info("primary Account is" + primaryAccount);
        model.addAttribute("primaryAccount",primaryAccount);
        return "primaryAccount";
    }

    @GetMapping("/savingsAccount")
    public String SavingsAccount(Model model,Principal principal){
        // TODO hat el savingsAccount bta3 user el 3ml sign in  >>   created by hassan shalash
        User user=userService.findByUsername(principal.getName());
        SavingsAccount savingsAccount=user.getSavingsAccount();
        logger.info("savings Account is" + savingsAccount);
        model.addAttribute("savingsAccount",savingsAccount);

        return "savingsAccount";
    }

    @GetMapping("/deposit")
    public String deposit(){

        return "deposit";
    }

    @GetMapping("/withdraw")
    public String withdraw (){

        return  "withdraw";
    }
}
