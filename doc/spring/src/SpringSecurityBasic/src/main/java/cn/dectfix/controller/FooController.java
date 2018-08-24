package cn.dectfix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by huqian on 2017/12/6.
 */
@Controller
public class FooController {
    @RequestMapping("foo1")
    @ResponseBody
    public String Foo1(){
        return "Foo1";
    }

    @RequestMapping("foo2")
    @ResponseBody
    public String Foo2(){
        return "Foo2";
    }
}
