package fb.blind.web.article.controller;

import fb.blind.common.NowDate;
import fb.blind.common.argumentresolver.Login;
import fb.blind.domain.article.service.ArticleService;
import fb.blind.domain.article.Article;
import fb.blind.common.SessionConst;
import fb.blind.domain.profile.repository.ProfileRepository;
import fb.blind.web.article.form.ArticleAddForm;
import fb.blind.web.article.form.ArticleEditForm;
import fb.blind.domain.kind.Kind;
import fb.blind.domain.user.User;
import fb.blind.domain.kind.service.KindService;
import fb.blind.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService as;

    private final KindService ks;

    private final UserService us;

    private final ProfileRepository pr;

    /**
     * @author 김성은,신영운
     * @param model test data
     * @return main 화면 이동
     */
//    @GetMapping
//    public String mainView(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) User loginUser,HttpServletRequest request, @ModelAttribute("kind") Kind kind, Model model){
//        List<Kind> result = ks.findAll();
//        model.addAttribute("kinds",result);
//
//        if (loginUser == null){
//            return "main";
//        }
//
//        model.addAttribute("user",loginUser);
//        return "loginmain";
//
//    }

    @GetMapping
    public String mainView(@Login User loginUser, HttpServletRequest request, @ModelAttribute("kind") Kind kind, Model model){

        model.addAttribute("kinds",ks.findAll());
        for (Kind kind1 : ks.findAll()) {
            log.info("kidsCheck : {}",kind1.getId());
        }

        if (loginUser == null){
            return "main";
        }

        model.addAttribute("user",loginUser);
        return "loginmain";
    }

    @GetMapping("/articleList/{kindId}")
    public String articleList(HttpServletRequest request,@PathVariable long kindId,Model model){

        List<Article> articles = as.articleList(kindId);
        Kind result = ks.getKindById(kindId).get();

        model.addAttribute("articles",articles);
        model.addAttribute("kind",result);

        HttpSession session = request.getSession(false);

        boolean logined = true;

        if(session == null){
            logined = false;
            model.addAttribute("logined",logined);
            return "articleList";
        }

        User user = (User) session.getAttribute(SessionConst.LOGIN_MEMBER);

        model.addAttribute("logined",user);

        return "articleList";
    }

    @GetMapping("/article/{articleId}")
    public String article(@Login User loginUser, @PathVariable long articleId,Model model){

        Article target = as.readArticle(articleId).get();

        Kind kind = ks.getKindById(target.getKindId()).get();

        model.addAttribute("article",target);
        model.addAttribute("kind",kind);
        model.addAttribute("owner",target.getUserId() == loginUser.getId());

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
            Article target = as.readArticle(form.getArticleId()).get();
            Kind kind = ks.getKindById(target.getKindId()).get();

            model.addAttribute("article",form);
            model.addAttribute("kind",kind);

            return "edit";
        }

        Article target = as.readArticle(form.getArticleId()).get();
        Article article = new Article(form.getArticleId(),form.getTitle(),form.getBody(),NowDate.getNowDate());
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
    public String add(@Login User loginUser,@Validated @ModelAttribute("article") ArticleAddForm form,BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model){

        if (bindingResult.hasErrors()) {
            List<Kind> result = ks.findAll();

            model.addAttribute("article",form);
            model.addAttribute("kindList", result);

            return "add";
        }

        Article article = new Article(form.getTitle(),form.getBody(), NowDate.getNowDate(),loginUser.getNickName(),loginUser.getId());
        Article result = as.addArticle(article);
        long kindId = ks.getKindByTitle(form.getKindName()).get().getId();

        article.setUserId(loginUser.getId());
        result.setKindId(kindId);

        redirectAttributes.addAttribute("articleId",result.getId());
        redirectAttributes.addAttribute("kindId",kindId);

        return "redirect:/articles/article/{articleId}";
    }

    @PostMapping("/delete/{articleId}")
    public String delete(@PathVariable Long articleId,RedirectAttributes redirectAttributes){

        Article target = as.readArticle(articleId).get();
        as.deleteArticle(target.getId());

        long kindId = target.getKindId();
        redirectAttributes.addAttribute("kindId",kindId);
        return "redirect:/articles/articleList/{kindId}";
    }
}
