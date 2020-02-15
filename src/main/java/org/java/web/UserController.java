package org.java.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
@Controller
public class UserController {
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String uname , HttpSession ses){
        ses.setAttribute("uname",uname);
        return "/main";
    }

}
