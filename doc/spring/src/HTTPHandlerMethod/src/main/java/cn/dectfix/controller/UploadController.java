package cn.dectfix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by huqian on 2017/12/11.
 */
@Controller
public class UploadController {
    @PostMapping("/form")
    @ResponseBody
    public String handleFormUpload(@RequestParam("name") String name, @RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        if (!file.isEmpty()) {
            String path = request.getSession().getServletContext().getRealPath("/")+"/upload";
            System.out.println(path+"#"+name);
            byte[] bytes = file.getBytes();
            FileOutputStream os = new FileOutputStream(path+"/"+name);
            os.write(bytes);
            os.flush();
            os.close();
            return "redirect:uploadSuccess";
        }
        return "redirect:uploadFailure";
    }
}
