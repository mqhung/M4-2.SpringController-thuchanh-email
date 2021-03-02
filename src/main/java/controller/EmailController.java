package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {

    public static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    @GetMapping("/check")
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("check");
        return modelAndView;
    }
    @PostMapping("/check")
    public ModelAndView checkEmail(String email){
        ModelAndView modelAndView = new ModelAndView("check");
        boolean isEmail = email.matches(EMAIL_REGEX);
        String result;
        if (isEmail) {
            result = "Email correct";
        } else {
            result = "Email failed";
        }
        modelAndView.addObject("result", result);
        return modelAndView;
    }
}
