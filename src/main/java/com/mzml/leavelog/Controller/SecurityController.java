package com.mzml.leavelog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {
        return "LoginFiles/plain-login";
    }
}
