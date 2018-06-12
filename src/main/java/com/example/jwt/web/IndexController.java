package com.example.jwt.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * IndexController
 *
 * @author lijiehua
 * @date 2018-06-12
 */
@Controller
public class IndexController {

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("name","中国上海");
        return "hello";
    }
}
