package cn.dectfix.controller;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * Created by huqian on 2017/12/11.
 */
@Controller
@RequestMapping("http")
public class HTTPController {

    @RequestMapping("rawGetParam")
    @ResponseBody
    public void rawGetParam(HttpServletRequest req, HttpServletResponse rep) throws IOException {
        String name = req.getParameter("name");
        OutputStream os = rep.getOutputStream();
        os.write(name.getBytes());
    }

    @RequestMapping("getParam")
    @ResponseBody
    public Object getParam(@RequestParam("name") String name){
        return name;
    }

    @RequestMapping("getParams")
    @ResponseBody
    public Object getParams(@RequestParam Map<String,Object> params){
        return convert(params);
    }

    @RequestMapping("postBody")
    @ResponseBody
    public Object postBody(@RequestBody String content){
        return content;
    }

    //TO-DO I have't know this annotation well
    @RequestMapping("requestPart")
    @ResponseBody
    public String requestPart(@RequestPart String name){
        return "TO-DO requestPart Demo";
    }

    @RequestMapping("requestHeader")
    @ResponseBody
    public Object requestHeader(@RequestHeader("host") String host){
        return host;
    }

    @RequestMapping("requestHeaders")
    @ResponseBody
    public Object requestHeaders(@RequestHeader Map<String,Object> params){
        return convert(params);
    }

    @RequestMapping("getCookie")
    @ResponseBody
    public String getCookie(@CookieValue("JSESSIONID") String JSESSIONID){
        return JSESSIONID;
    }

    @RequestMapping("getCookies")
    @ResponseBody
    public String getCookies(@CookieValue Map<String,Object> cookies){
        return convert(cookies);
    }

    private String convert(Object obj){
        JSONObject json = JSONObject.fromObject(obj);
        return json.toString();
    }

}
