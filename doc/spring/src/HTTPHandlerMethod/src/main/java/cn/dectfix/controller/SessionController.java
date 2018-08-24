package cn.dectfix.controller;

import net.sf.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by huqian on 2017/12/11.
 */
@Controller
@RequestMapping("session")
@SessionAttributes(value={"attr1","attr2"})
public class SessionController {
    @RequestMapping(params="method=index1")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index.jsp");
        mav.addObject("attr1", "attr1Value");
        mav.addObject("attr2", "attr2Value");
        mav.addObject("attr3", "attr3Value");
        return mav;
    }

    @RequestMapping(params="method=index2")
    public void index2(@ModelAttribute("attr1")String attr1, @ModelAttribute("attr2")String attr2, @ModelAttribute("attr3")String attr3, HttpServletResponse rep) throws IOException {
        String res = "attr1:"+attr1+"#attr2:"+attr2+"#attr3:"+attr3+"#";
        OutputStream os = rep.getOutputStream();
        os.write(res.getBytes());
    }

    @RequestMapping(params="method=index3")
    public void index3(ModelMap model,HttpServletResponse rep) throws IOException {
        String res = convert(model);
        OutputStream os = rep.getOutputStream();
        os.write(res.getBytes());
    }

    @RequestMapping(params="method=index4")
    public void index4(HttpSession session, HttpServletResponse rep) throws IOException {
        String attr1 = (String) session.getAttribute("attr1");
        OutputStream os = rep.getOutputStream();
        os.write(attr1.getBytes());
    }

    @RequestMapping(params="method=index5")
    public void index5(HttpSession session, HttpServletResponse rep) throws IOException {
        session.invalidate();
        String res = "close!";
        OutputStream os = rep.getOutputStream();
        os.write(res.getBytes());
    }

    private String convert(Object obj){
        JSONObject json = JSONObject.fromObject(obj);
        return json.toString();
    }
}
