package com.hassan.OnlineBanking.Controller;


import com.hassan.OnlineBanking.Service.TransactionService;
import com.hassan.OnlineBanking.Service.UserService;
import com.hassan.OnlineBanking.models.PrimaryAccount;
import com.hassan.OnlineBanking.models.SavingsAccount;
import com.hassan.OnlineBanking.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Author : hassan shalash
 *
 * 20/6/2023
 *
 * */
@Controller
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private UserService userService;


    @GetMapping(value = "/betweenAccounts")
    public String betweenAccounts(Model model){

        model.addAttribute("transferFrom","");
        model.addAttribute("transferTo","");
        model.addAttribute("amount","");

        return "betweenAccounts";
    }
    @PostMapping(value = "/betweenAccounts")
    public String betweenAccountsPost(Model model ,
                                      @ModelAttribute("transferFrom") String transferFrom,
                                      @ModelAttribute("transferTo") String transferTo,
                                      @ModelAttribute("amount") String amount ,
                                      Principal principal)
            throws Exception {

        User user=userService.findByUsername(principal.getName());
        PrimaryAccount primaryAccount = user.getPrimaryAccount();
        SavingsAccount savingsAccount = user.getSavingsAccount();
        transactionService.betweenAccountsTransfer(transferFrom,transferTo,amount,primaryAccount ,savingsAccount);

        return "redirect:/userFront";
    }


}
