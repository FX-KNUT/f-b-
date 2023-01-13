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
    public String find(Model model){



        model.addAttribute("question","result");

        return "find";
    }


}
