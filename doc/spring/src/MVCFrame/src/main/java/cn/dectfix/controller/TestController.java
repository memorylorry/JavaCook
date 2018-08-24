package cn.dectfix.controller;

import cn.dectfix.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by huqian on 2017/12/6.
 */
@Controller
@RequestMapping("base")
public class TestController {

    @Autowired
    @Qualifier("baseService")
    private BaseService baseService;

    @RequestMapping("foo")
    @ResponseBody
    public String Foo(){
        return "Controller-foo#"+baseService.look("TestController");
    }
}
