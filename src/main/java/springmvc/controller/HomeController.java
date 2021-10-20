package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{
    @RequestMapping("/")
    public String showPage()
    {
        System.out.println("hello jesus");
        return "main-menu";
    }

}
