package cn.dectfix.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by huqian on 2018/3/9.
 */
@Controller
public class TestController {
    @RequestMapping("/list")
    @ResponseBody
    @Secured("ROLE_LIST")
    public String list(){
        return "You can see list.";
    }

    @RequestMapping("/table")
    @ResponseBody
    @Secured("ROLE_TABLE")
    public String table(){
        return "You can see table.";
    }

    @RequestMapping("/chart")
    @ResponseBody
    @Secured("ROLE_CHART")
    public String chart(){
        return "You can see chart.";
    }
}
