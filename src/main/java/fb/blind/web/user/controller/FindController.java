package fb.blind.web.user.controller;

import fb.blind.common.TokenPwConst;
import fb.blind.common.argumentresolver.Login;
import fb.blind.domain.profile.repository.ProfileRepository;
import fb.blind.domain.question.Question;
import fb.blind.domain.question.repository.QuestionRepository;
import fb.blind.domain.user.User;
import fb.blind.domain.user.service.UserService;
import fb.blind.domain.user.service.UserServiceImpl;
import fb.blind.web.user.form.FindForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Slf4j
@Controller
@RequestMapping("/find")
@RequiredArgsConstructor
public class FindController {

    private final QuestionRepository qr;
    private final UserService us;
    private final ProfileRepository pr;


    @GetMapping
    public String findForm(Model model){

        model.addAttribute("question","result");
        model.addAttribute("find", new FindForm());
        return "find";
    }

    // e-mail 인증 -> question 받아와서 등록하기 -> answer 받아와 user 인증 후 임시 비밀 번호 setting 및 발급 해주기
    @PostMapping("/emailCheck")
    public String find(@ModelAttribute FindForm form, BindingResult bindingResult, Model model){

        String email = form.getEmail();
        Optional<User> findUser = us.findByEmail(email);

        if(findUser.isEmpty()) {
            bindingResult.reject("loginError");
            model.addAttribute("find",form);
            return "find";
        }

        String question = qr.findByUserId(findUser.get().getId()).getQuestion();
        log.info("question : {}", question);
        form.setQuestion(question);

        model.addAttribute("find",form);


        return "find";
    }

    @PostMapping("/findPw")
    public String findPw(@ModelAttribute FindForm form, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("answerCheck",false);
            model.addAttribute("find",form);
            return "find";
        }

        Optional<User> findUser = us.findByEmail(form.getEmail());

        if(findUser.isEmpty()){
            model.addAttribute("answerCheck",false);
            model.addAttribute("find",form);
            return "find";
        }

        Question target = qr.findByUserId(findUser.get().getId());

        log.info("form answer : {}",form.getAnswer());
        log.info("qr answer : {}",target.getAnswer());

        if(!form.getAnswer().equals(target.getAnswer())){
            model.addAttribute("answerCheck",false);
            model.addAttribute("find",form);
            return "find";
        }

        findUser.get().setPasswd(TokenPwConst.TOKEN_PW);
        model.addAttribute("find",form);
        model.addAttribute("answerCheck",true);
        model.addAttribute("tokenPw", TokenPwConst.TOKEN_PW);

        return "find";
    }


}
