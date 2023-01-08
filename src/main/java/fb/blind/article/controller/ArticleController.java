package fb.blind.article.controller;

import fb.blind.article.service.ArticleService;
import fb.blind.domain.article.Article;
import fb.blind.domain.kind.Kind;
import fb.blind.kind.service.KindService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/articles")
public class ArticleController {

    private ArticleService as;
    private KindService ks;
    @Autowired
    public ArticleController(ArticleService as,KindService ks) {
        this.as = as;
        this.ks = ks;
    }

    /**
     * @author 김성은,신영운
     * @param model test data
     * @return main 화면 이동
     */
    @GetMapping
    public String mainView(Model model){
        List<Kind> result = ks.findAll();
        model.addAttribute("kind",result);
        return "main";
    }

    @GetMapping("/articleList/{kindId}")
    public String articleList(@PathVariable long kindId,Model model){

        List<Article> articles = as.articleList(kindId);
        Kind kind = ks.getKindById(kindId).get();
        model.addAttribute("articles",articles);
        model.addAttribute("kind",kind);


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
    public String edit(@ModelAttribute Article article,RedirectAttributes redirectAttributes){
        long id = article.getId();
        Article target = as.readArticle(id).get();
        log.info("title ={} ", target.getTitle());
        Article updated = as.updateArticle(article);
        log.info("updated = {} ",updated.getTitle());
        redirectAttributes.addAttribute("articleId", id);
        return "redirect:/articles/article/{articleId}";
    }



}
