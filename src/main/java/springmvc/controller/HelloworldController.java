package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class HelloworldController
{

    @RequestMapping("/showForm")
    public String showForm()     //show form
    {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm()           //process form
    {
        return "helloworld";
    }

    //new controller method to read form data

    @RequestMapping("/processFormTwo")
    public String letsShout(HttpServletRequest request, Model model)
    {
        //read request parameter from form data
        String theName=request.getParameter("studentName");
       theName= theName.toUpperCase();
       //create message
        String result= "YO " + theName;

        //add message to model
        model.addAttribute("message",result);

        return "helloworld";
    }

    @RequestMapping("/processFormThree")
    public String processFormThree(@RequestParam("studentName") String theName, Model model)
    {
        //read request parameter from form data

        theName= theName.toUpperCase();
        //create message
        String result= "Hey my friend from v3  " + theName;

        //add message to model
        model.addAttribute("message",result);

        return "helloworld";
    }
}
