package com.hassan.OnlineBanking;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Test {

    @GetMapping("/test")
    public String test(){
        return "common/header";
    }
}
