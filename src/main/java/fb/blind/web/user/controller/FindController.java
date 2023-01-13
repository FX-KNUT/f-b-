package fb.blind.web.user.controller;

import fb.blind.common.argumentresolver.Login;
import fb.blind.domain.question.Question;
import fb.blind.domain.question.repository.QuestionRepository;
import fb.blind.domain.user.User;
import fb.blind.domain.user.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/find")
@RequiredArgsConstructor
public class FindController {

    private final QuestionRepository qr;

    @GetMapping
    public String findForm(Model model){

        model.addAttribute("question","result");

        return "find";
    }

    // e-mail 인증 -> question 받아와서 등록하기 -> answer 받아와 user 인증 후 임시 비밀 번화 setting 및 발급 해주기
    @PostMapping("/emailCheck")
    public String find(Model model){
        log.info("here");

        return "find";
    }


}
