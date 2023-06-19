package com.hassan.OnlineBanking.Controller;

import com.hassan.OnlineBanking.Service.AccountService;
import com.hassan.OnlineBanking.Service.TransactionService;
import com.hassan.OnlineBanking.Service.UserService;
import com.hassan.OnlineBanking.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;


    @GetMapping("/primaryAccount")
    public String primaryAccount(Model model,Principal principal){
        // TODO hat el primaryAccount bta3 user el 3ml sign in  >>   created by hassan shalash ##

        List<PrimaryTransaction> primaryTransactionList = transactionService.findPrimaryTransactionList(principal.getName());
        User user=userService.findByUsername(principal.getName());
        PrimaryAccount primaryAccount=user.getPrimaryAccount();
        logger.info("primary Account is" + primaryAccount);

        model.addAttribute("primaryAccount",primaryAccount);
        model.addAttribute("primaryTransactionList", primaryTransactionList);

        return "primaryAccount";
    }

    @GetMapping("/savingsAccount")
    public String SavingsAccount(Model model,Principal principal){
        // TODO hat el savingsAccount bta3 user el 3ml sign in  >>   created by hassan shalash  ##

        List<SavingsTransaction> savingsTransactionList =transactionService.findSavingsTransactionList(principal.getName());
        User user=userService.findByUsername(principal.getName());
        SavingsAccount savingsAccount=user.getSavingsAccount();
        logger.info("savings Account is" + savingsAccount);

        model.addAttribute("savingsAccount",savingsAccount);
        model.addAttribute("savingsTransactionList",savingsTransactionList);

        return "savingsAccount";
    }

    @RequestMapping(value = "/deposit", method = RequestMethod.GET)
    public String deposit(Model model) {
        model.addAttribute("accountType", "");
        model.addAttribute("amount", "");

        return "deposit";
    }

    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    public String depositPOST(@ModelAttribute("amount") String amount, @ModelAttribute("accountType") String accountType, Principal principal) {
        accountService.deposit(accountType, Double.parseDouble(amount), principal);

        return "redirect:/userFront";
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.GET)
    public String withdraw(Model model) {
        model.addAttribute("accountType", "");
        model.addAttribute("amount", "");

        return "withdraw";
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    public String withdrawPOST(@ModelAttribute("amount") String amount, @ModelAttribute("accountType") String accountType, Principal principal) {
        accountService.withdraw(accountType, Double.parseDouble(amount), principal);

        return "redirect:/userFront";
    }
}
