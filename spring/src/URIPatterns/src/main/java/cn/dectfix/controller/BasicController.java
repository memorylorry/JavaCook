package cn.dectfix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by huqian on 2017/12/11.
 */
@Controller
@RequestMapping("basic")
public class BasicController {

    @RequestMapping("simple")
    @ResponseBody
    public String Simple(){
        return "SimpleGet";
    }

    @RequestMapping("path/{val}")
    @ResponseBody
    public String Path(@PathVariable String val){
        return "Path#"+val;
    }

    @RequestMapping("path2/{val1}/mid/{val2}")
    @ResponseBody
    public String Path2(@PathVariable String val1,@PathVariable String val2){
        return "Path2#val1:"+val1+"&val2:"+val2;
    }

    @GetMapping("//{name:[a-z-]+}-{version:\\d\\.\\d\\.\\d}{ext:\\.[a-z]+}")
    @ResponseBody
    public String Regex(@PathVariable String name, @PathVariable String version, @PathVariable String ext, HttpServletResponse rep) {
        rep.setHeader("Content-Type","html/text");
        return "Regex#Name:"+name+"&Ver:"+version+"&ext:"+ext;
    }

}
