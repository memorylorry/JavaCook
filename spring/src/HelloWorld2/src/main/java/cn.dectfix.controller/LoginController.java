package cn.dectfix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by huqian on 2017/12/6.
 */
@Controller
public class LoginController {

    @RequestMapping("/foo1")
    @ResponseBody
    public String Foo1(){
        return "Foo1!";
    }

    /*
     * Integer is not support by browser. If needed, you would combine spring with fastjson or others
     * In other project I will give a example to solve this problem.
     */
    @RequestMapping("/foo2")
    @ResponseBody
    public int Foo2(){
        return 1;
    }

    @RequestMapping("/foo3")
    @ResponseBody
    public String Foo3(HttpServletRequest req, HttpServletResponse rep, @RequestParam Map<String,Object> params){
        //get msg parameter from http content
        String msg = (String) params.get("msg");
        rep.setHeader("Content-Type","plain/text");
        return msg;
    }

}
