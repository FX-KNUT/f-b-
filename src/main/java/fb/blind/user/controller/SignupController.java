package fb.blind.user.controller;

import fb.blind.domain.user.LoginForm;
import fb.blind.domain.user.SignupForm;
import fb.blind.domain.user.User;
import fb.blind.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/signup")
@RequiredArgsConstructor
public class SignupController {

    private final UserService us;

    @GetMapping
    public String signupForm(@ModelAttribute("user") SignupForm form, BindingResult bindingResult, Model model){

        model.addAttribute("user",form);

        return "signup";
    }

    @PostMapping
    public String signup(@Validated @ModelAttribute("user") SignupForm form, BindingResult bindingResult, Model model){

        boolean joined = false;

        User user = new User(form.getDept(),form.getNick(),form.getId(),form.getPw2());
        Optional<User> userByEmail = us.findUserByEmail(user.getEmail());


        if(bindingResult.hasErrors() || !userByEmail.isEmpty()){
            model.addAttribute("user",form);
            model.addAttribute("joined",joined);
            if(!userByEmail.isEmpty()){
                bindingResult.reject("joined","joinedFail");
            }
            return "signup";
        }

        joined = us.join(user);

        model.addAttribute("user", new LoginForm());
        model.addAttribute("joined",joined);

        return "login";
    }

}
