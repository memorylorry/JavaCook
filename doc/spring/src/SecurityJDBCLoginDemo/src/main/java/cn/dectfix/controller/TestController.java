package cn.dectfix.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by huqian on 2017/12/17.
 */
@Controller
public class TestController {

    @RequestMapping("user")
    public String user() {
        return "user";
    }

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping("admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login(ModelAndView model, HttpServletRequest req) {
        model.setViewName("login");
        return model;
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
}
