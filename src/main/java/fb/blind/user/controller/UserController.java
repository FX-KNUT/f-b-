package fb.blind.user.controller;

import fb.blind.domain.user.User;
import fb.blind.user.service.MemoryUserService;
import fb.blind.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Slf4j
@Controller
@RequestMapping("/templates")
public class UserController {

    private final UserService userService;

    public UserController(UserService userservice){
        this.userService= userservice;
    }

    @GetMapping("/templates")
    public String home(){
        return "main";
    }

    @GetMapping("/user/{userNickName}")
    public String printLog(@PathVariable String nickName, HttpServletRequest request, HttpServletResponse response){
        log.info("requestURI : {}", request.getRequestURI());
        log.info("userNickName : {}", nickName);
        return "main";
    }



    @PostMapping("/main")
    @ResponseBody
    public String formTest(@ModelAttribute UserData userData){
        log.info("nickName:{}",userData.getNickName());
        log.info("passwd:{}", userData.getPasswd());

        return "pass";
    }


}
