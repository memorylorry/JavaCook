package cn.dectfix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by huqian on 2017/12/7.
 */
@Controller
public class TestController {
    @RequestMapping("foo1")
    @ResponseBody
    public String foo1(){
        return "Hello boot1!";
    }

    @RequestMapping("foo2")
    @ResponseBody
    public String foo2(){
        return "Hello boot2!";
    }
}
