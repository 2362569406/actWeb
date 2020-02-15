package org.java.web;

import org.activiti.engine.TaskService;
import org.java.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class OrderController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private OrderService orderService;
    @RequestMapping(value = "createOrder",method = RequestMethod.POST)
    public String createOrder(HttpSession session, @RequestParam Map map){
        //从session中获取用户id
        String uname = (String) session.getAttribute("uname");
        //封装到map
        map.put("userId",uname);
        //创建采购单
        orderService.createOrder(map);
        return "redirect:queryPersonTask.do";
    }

}
