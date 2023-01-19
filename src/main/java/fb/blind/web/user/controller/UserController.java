package fb.blind.web.user.controller;

import fb.blind.common.argumentresolver.Login;
import fb.blind.domain.article.Article;
import fb.blind.domain.article.repository.ArticleRepository;
import fb.blind.domain.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/myArticleList")
@RequiredArgsConstructor
public class UserController {
    private final ArticleRepository ar;

    @GetMapping
    public void myarticlelist(@Login Article loginUser, Model model) {
        List<Article> articles = ar.findByUserId(loginUser.getUserId());

        model.addAttribute("articles",articles);
    }
}
