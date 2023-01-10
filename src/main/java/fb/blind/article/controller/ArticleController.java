package fb.blind.article.controller;

import fb.blind.article.service.ArticleService;
import fb.blind.domain.article.Article;
import fb.blind.domain.article.ArticleAddForm;
import fb.blind.domain.article.ArticleEditForm;
import fb.blind.domain.kind.Kind;
import fb.blind.kind.service.KindService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingErrorProcessor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    public String mainView(@ModelAttribute Kind kind, Model model){
        List<Kind> result = ks.findAll();
        model.addAttribute("kinds",result);
        model.addAttribute("kind",new Kind());
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
        Kind kind = ks.getKindById(target.getKindId()).get();

        model.addAttribute("article",target);
        model.addAttribute("kind",kind);

        return "article";
    }

    @GetMapping("/edit/{articleId}")
    public String articleEdit(@PathVariable long articleId,Model model){

        Article target = as.readArticle(articleId).get();
        Kind kind = ks.getKindById(target.getKindId()).get();
        ArticleEditForm form = new ArticleEditForm();
        form.setArticleId(target.getId());
        form.setTitle(target.getTitle());
        form.setBody(target.getBody());

        model.addAttribute("article",form);
        model.addAttribute("kind",kind);

        return "edit";
    }

    @PostMapping("/edit/{articleId}")
    public String edit(@Validated @ModelAttribute("article") ArticleEditForm form, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model){

        if(bindingResult.hasErrors()){
            log.info("in test");
            Article target = as.readArticle(form.getArticleId()).get();
            Kind kind = ks.getKindById(target.getKindId()).get();

            model.addAttribute("article",form);
            model.addAttribute("kind",kind);

            return "edit";
        }

        Article target = as.readArticle(form.getArticleId()).get();
        Article article = new Article(form.getArticleId(),form.getTitle(),form.getBody());
        as.updateArticle(article);

        long kindId = target.getKindId();
        Kind kind = ks.getKindById(kindId).get();

        redirectAttributes.addAttribute("articleId", form.getArticleId());
        redirectAttributes.addAttribute("kind",kind.getKindName());

        return "redirect:/articles/article/{articleId}";
    }

    @GetMapping("/add")
    public String addform(Model model){
        List<Kind> result = ks.findAll();

        model.addAttribute("article",new ArticleAddForm());
        model.addAttribute("kindList", result);

        return "add";
    }

    @PostMapping("/add")
    public String add(@Validated @ModelAttribute("article") ArticleAddForm form,BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model){

        if (bindingResult.hasErrors()) {
            List<Kind> result = ks.findAll();

            model.addAttribute("article",form);
            model.addAttribute("kindList", result);

            return "add";
        }

        Article article = new Article(form.getTitle(),form.getBody());
        Article result = as.addArticle(article);
        long kindId = ks.getKindByTitle(form.getKindName()).get().getId();
        article.setUserId(kindId);


        result.setKindId(kindId);
        redirectAttributes.addAttribute("articleId",result.getId());
        redirectAttributes.addAttribute("kindId",kindId);

        return "redirect:/articles/article/{articleId}";
    }

}
