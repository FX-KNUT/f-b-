package fb.blind.article.controller;

import fb.blind.domain.Gender;
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


    /**
     * @param model test data
     * @return main 화면 이동
     */
    @GetMapping
    public String mainView(Model model){
        model.addAttribute("test","Main Page");
        log.info("gender = {}", Gender.M.getGender());
        return "main";

    }

}
