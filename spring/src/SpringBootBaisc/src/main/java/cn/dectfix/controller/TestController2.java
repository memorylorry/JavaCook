package cn.dectfix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by huqian on 2017/12/7.
 */
@Controller
public class TestController2 {
    @RequestMapping("hoo1")
    @ResponseBody
    public String hoo1(){
        return "Hello hoot1!";
    }

    @RequestMapping("hoo2")
    @ResponseBody
    public String hoo2(){
        return "Hello hoot2!";
    }
}
