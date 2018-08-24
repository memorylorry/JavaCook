package cn.dectfix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by huqian on 2017/12/13.
 */
@Controller
public class TestController {

    @RequestMapping("view1")
    public String view1(){
        return "view1";
    }

    @RequestMapping("view2")
    public String view2(){
        return "view2";
    }

    @RequestMapping("view3")
    public String view3(){
        return "view3";
    }

    @RequestMapping("view4")
    @ResponseBody
    public String view4(){
        return "view4";
    }

}
