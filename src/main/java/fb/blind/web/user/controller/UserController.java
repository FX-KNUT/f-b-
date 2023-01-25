package fb.blind.web.user.controller;

import fb.blind.domain.user.User;
import fb.blind.domain.user.service.UserService;
import fb.blind.web.user.form.SignupForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService us;

    public UserController(UserService us) {
        this.us = us;
    }

    // 회원정보 수정을 하고싶습니다.
    @Bean
    public void userNickChange(String nick,@Validated @ModelAttribute("user") SignupForm form){
        if(us.findUserByNick(nick) != null) {
            return;
        }

        User user = new User(form.getDept(),nick,form.getEmail(),form.getPw2());
        us.join(user);

    }

}
