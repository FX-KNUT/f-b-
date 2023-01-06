package fb.blind.article.controller;

import fb.blind.article.repository.ArticleRepository;
import fb.blind.article.repository.MemoryArticleRepository;
import fb.blind.article.service.ArticleService;
import fb.blind.domain.Gender;
import fb.blind.domain.article.Article;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/articles")
public class ArticleController {

    private ArticleService as;

    @Autowired
    public ArticleController(ArticleService as) {
        this.as = as;
    }

    /**
     * @author 김성은,신영운
     * @param model test data
     * @return main 화면 이동
     */
    @GetMapping
    public String mainView(Model model){
        model.addAttribute("test","Main Page");
        return "main";
    }

    @GetMapping("/articleList")
    public String articleList(Model model){

        List<Article> articles = as.articleList();
        model.addAttribute("articles",articles);

        return "articleList";
    }

    @GetMapping("/article/{articleId}")
    public String article(@PathVariable long articleId,Model model){
        Article target = as.readArticle(articleId).get();
        model.addAttribute("article",target);
        return "article";
    }

    @GetMapping("/edit/{articleId}")
    public String articleEdit(@PathVariable long articleId,Model model){
        Article target = as.readArticle(articleId).get();
        model.addAttribute("article",target);
        return "edit";
    }

    @PostMapping("/edit/{articleId}")
    public String  edit(@ModelAttribute Article article,RedirectAttributes redirectAttributes){
        long id = article.getId();
        Article target = as.readArticle(id).get();
        log.info("title ={} ", target.getTitle());
        Article updated = as.updateArticle(article);
        log.info("updated = {} ",updated.getTitle());
        redirectAttributes.addAttribute("articleId", id);
        return "redirect:/articles/article/{articleId}";
    }



}
