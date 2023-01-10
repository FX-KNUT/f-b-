package fb.blind.user.controller;


import fb.blind.domain.user.LoginForm;
import fb.blind.domain.user.User;
import fb.blind.user.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService ls;


    @GetMapping
    public String loginForm(@ModelAttribute("user") LoginForm form){
        return "login";
    }

    @PostMapping
    public String login(@Validated @ModelAttribute("user") LoginForm form, BindingResult bindingResult, HttpServletRequest request){

        if(bindingResult.hasErrors()){
            return "login";
        }

        User loginUser = ls.login(form.getInputId(), form.getInputPw());

        if (loginUser == null){
            bindingResult.reject("loginError","아이디 또는 비밀번호 fail");
            return "login";
        }


        HttpSession session = request.getSession();

        session.setAttribute("memberId",loginUser);

        return "redirect:/articles";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        log.info("logout Process");

        HttpSession session = request.getSession(false);

        if(session != null){
            session.invalidate();
        }

        return "redirect:/articles";
    }

    private void expiredCookie(HttpServletResponse response, String cookieName) {
        log.info("expiredCookie Process");
        Cookie cookie = new Cookie(cookieName,null);
        cookie.setMaxAge(0);
        log.info("setMaxAge after");
        response.addCookie(cookie);
    }


}
