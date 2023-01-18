package fb.blind.web.user.controller;

import fb.blind.domain.Gender;
import fb.blind.domain.profile.Profile;
import fb.blind.domain.profile.repository.ProfileRepository;
import fb.blind.domain.question.Question;
import fb.blind.domain.question.QuestionCode;
import fb.blind.domain.question.repository.QuestionRepository;
import fb.blind.web.user.form.LoginForm;
import fb.blind.web.user.form.SignupForm;
import fb.blind.domain.user.User;
import fb.blind.domain.user.service.UserService;
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

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/signup")
@RequiredArgsConstructor
public class SignupController {

    private final UserService us;
    private final QuestionRepository qr;
    private final ProfileRepository pr;

    @GetMapping
    public String signupForm(@ModelAttribute("user") SignupForm form, BindingResult bindingResult, Model model){

        model.addAttribute("user",form);
        return "signup";

    }

    @PostMapping
    public String signup(@Validated @ModelAttribute("user") SignupForm form, BindingResult bindingResult, Model model){

        User user = new User(form.getDept(),form.getNick(),form.getEmail(),form.getPw2());

        us.checkedFormPolicy(user,bindingResult);

        if(bindingResult.hasErrors()){
            model.addAttribute("user",form);
            return "signup";
        }

        us.join(user);

        long joinedUserId = us.findByEmail(user.getEmail()).get().getId();
        Question question = new Question(form.getQuestion(), form.getAnswer(), joinedUserId);
        qr.save(question);

        Profile profile = new Profile(Gender.valueOf(form.getGender()), null, joinedUserId);
        pr.save(profile);
        
        model.addAttribute("user", new LoginForm());

        return "login";
    }

    @ModelAttribute("QuestionCodes")
    public List<QuestionCode> deliveryCodes(){
        List<QuestionCode> deliveryCodes = new ArrayList<>();
        deliveryCodes.add(new QuestionCode( "본인의 고향은?"));
        deliveryCodes.add(new QuestionCode( "본인의 취미는?"));
        deliveryCodes.add(new QuestionCode( "본인의 초등학교 별명은?"));
        return deliveryCodes;
    }


}
