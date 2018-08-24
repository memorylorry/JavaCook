package cn.dectfix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by huqian on 2017/12/6.
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    @ResponseBody
    public String Login(){
        return "Login!";
    }
}
