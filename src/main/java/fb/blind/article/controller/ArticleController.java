package fb.blind.article.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/articles")
public class ArticleController {

    @GetMapping
    public String mainView(Model model){
        model.addAttribute("test","Main Page");
        return "main";
    }

}