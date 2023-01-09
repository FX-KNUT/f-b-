package fb.blind.article.controller;

import fb.blind.article.service.ArticleService;
import fb.blind.domain.article.Article;
import fb.blind.domain.article.ArticleAddForm;
import fb.blind.domain.kind.Kind;
import fb.blind.kind.service.KindService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService as;
    private final KindService ks;

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
        Kind result = ks.getKindById(kindId).get();
        model.addAttribute("articles",articles);
        model.addAttribute("kind",result);

        return "articleList";
    }

    @GetMapping("/article/{articleId}")
    public String article(@PathVariable long articleId,Model model){
        Article target = as.readArticle(articleId).get();
        model.addAttribute("article",target);
        long kindId = target.getKindId();
        Kind kind = ks.getKindById(kindId).get();
        model.addAttribute("kind",kind);
        return "article";
    }

    @GetMapping("/edit/{articleId}")
    public String articleEdit(@PathVariable long articleId,Model model){
        Article target = as.readArticle(articleId).get();
        model.addAttribute("article",target);
        long kindId = target.getKindId();
        Kind kind = ks.getKindById(kindId).get();
        model.addAttribute("kind",kind);

        return "edit";
    }

    @PostMapping("/edit/{articleId}")
    public String edit(@ModelAttribute Article article,RedirectAttributes redirectAttributes){
        long id = article.getId();
        Article target = as.readArticle(id).get();
        Article updated = as.updateArticle(article);
        long kindId = target.getKindId();
        Kind kind = ks.getKindById(kindId).get();
        redirectAttributes.addAttribute("articleId", id);
        redirectAttributes.addAttribute("kind",kind.getKindName());
        return "redirect:/articles/article/{articleId}";
    }

    @GetMapping("/add")
    public String addform(Model model){
        model.addAttribute("article",new Article());
        List<Kind> result = ks.findAll();
        model.addAttribute("kindList", result);
        model.addAttribute("kind",new Kind());
        return "add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Article article,@RequestParam String kindName,RedirectAttributes redirectAttributes){
        Article result = as.addArticle(article);
        long kindId = ks.getKindByTitle(kindName).get().getId();
        result.setKindId(kindId);
        redirectAttributes.addAttribute("articleId",result.getId());
        redirectAttributes.addAttribute("kindId",kindId);
        return "redirect:/articles/article/{articleId}";
    }

}
