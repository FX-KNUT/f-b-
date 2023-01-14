package fb.blind.web.user.controller;

import fb.blind.common.argumentresolver.Login;
import fb.blind.domain.article.Article;
import fb.blind.domain.kind.Kind;
import fb.blind.domain.user.User;
import fb.blind.domain.user.service.UserService;
import fb.blind.web.user.form.EditPwForm;
import fb.blind.web.user.form.LoginForm;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService us;


    @GetMapping("/editPasswd")
    public String editPwForm(Model model){
        model.addAttribute("passwd",new EditPwForm());
        return "editpasswd";
    }

    @PostMapping("/changepw")
    public String changPw(@Login User loginUser, @Validated @ModelAttribute("passwd") EditPwForm form, BindingResult bindingResult, HttpServletRequest request, Model model){

        if(bindingResult.hasErrors()){
            log.info("here");
            return "editpasswd";
        }

        loginUser.setPasswd(form.getPw1());

        HttpSession session = request.getSession(false);if(session != null){
            session.invalidate();
        }

        return "redirect:/login";
    }

}
