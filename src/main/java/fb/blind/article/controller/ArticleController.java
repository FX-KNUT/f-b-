package fb.blind.article.controller;

import fb.blind.article.repository.ArticleRepository;
import fb.blind.article.repository.MemoryArticleRepository;
import fb.blind.domain.Gender;
import fb.blind.domain.article.Article;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/articles")

public class ArticleController {

    private ArticleRepository ar;

    @Autowired
    public ArticleController(ArticleRepository ar) {
        this.ar = ar;
    }

    /**
     * @author 김성은,신영운
     * @param model test data
     * @return main 화면 이동
     */
    @GetMapping
    public String mainView(Model model){
        model.addAttribute("test","Main Page");
        log.info("gender = {}", Gender.M.getGender());
        List<Article> articleList = ar.findAll();
        if(articleList != null){
            for (Article article : articleList) {
                log.info(article.getTitle());
            }
        }

        return "main";

    }

}
