package springmvc.controller;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import springmvc.model.Student;

import javax.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController
{

    @InitBinder
    public void InitBinder(WebDataBinder webDataBinder)
    {
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @RequestMapping("/showForm")
    public String showForm(Model m)
    {
        Student theStudent=new Student();       //create student object
        m.addAttribute("student",theStudent);   //add object to model
        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("student") Student theStudent,
                              BindingResult theBindingResult) {
        if (theBindingResult.hasErrors()) {
            System.out.println("it has errors");
            return "student-form";
        } else {
            System.out.println("hi " + theStudent.getFirstName());
            return "student-confirmation";
        }
    }

}
