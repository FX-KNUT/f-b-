package fb.blind.user.controller;


import fb.blind.domain.user.LoginForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.Binding;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String loginForm(@ModelAttribute LoginForm form, BindingResult bindingResult, Model model){

        model.addAttribute("user",form);

        return "login";
    }

    @PostMapping
    public String login(@Validated @ModelAttribute("user") LoginForm form, BindingResult bindingResult,Model model){

        if(bindingResult.hasErrors()){
            log.info("login input error check");
            model.addAttribute("user",form);
            return "login";
        }

        log.info("InputId : {}",form.getInputId());
        log.info("InputPW : {}",form.getInputPw());
        model.addAttribute("user",form);
        return "login";
    }


}
