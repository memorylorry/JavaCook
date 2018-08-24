package cn.dectfix.controller;

import cn.dectfix.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huqian on 2017/12/12.
 */
@Controller
@RequestMapping("test")
public class TestController {

    @RequestMapping("getInt")
    @ResponseBody
    public int getInt(){
        return 10;
    }

    @RequestMapping("getString")
    @ResponseBody
    public String getString(){
        return "Hello world！";
    }

    @RequestMapping("getUser")
    @ResponseBody
    public User getUser(){
        User u = new User();
        u.setUsername("Tom");
        u.setPasswd("123456");
        return u;
    }

    @RequestMapping("getMap")
    @ResponseBody
    public Map<String, Object> getMap(){
        int []nums = {3,5,1,4,12,4};
        Map<String,Object> data = new HashMap();
        List<Integer> list = new ArrayList();
        for (int a:nums) {
            list.add(a);
        }
        data.put("list",list);
        data.put("lenght",list.size());
        return data;
    }

}
