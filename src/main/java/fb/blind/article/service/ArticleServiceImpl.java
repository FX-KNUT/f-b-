package fb.blind.article.service;

import fb.blind.article.repository.ArticleRepository;
import fb.blind.domain.article.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService{

    private final ArticleRepository ar;

    @Autowired
    public ArticleServiceImpl(ArticleRepository ar) {
        this.ar = ar;
    }

    @Override
    public Article addArticle(Article article) {
        return ar.save(article);
    }

    @Override
    public Optional<Article> readArticle(long articleId) {
        return ar.findByArticleId(articleId);
    }

    /**
     * date 부분 reversion 필요
     * @param article article 고유 id
     * @return
     */
    @Override
    public Article updateArticle(Article article) {
        Article target = ar.findByArticleId(article.getId()).get();
        target.setTitle(article.getTitle());
        target.setBody(article.getBody());
        //target.setDate(article.getDate());
        target.setFileName(article.getFileName());
        return target;
    }

    @Override
    public void deleteArticle(long articleId) {
        ar.delete(articleId);
    }

    @Override
    public List<Article> articleList() {
        return ar.findAll();
    }

    @Override
    public String getURL(long articleId) {
        return "http://localhost8080/articles/" + articleId;
    }

    @Override
    public long getViews(long articleId) {
        Article target = ar.findByArticleId(articleId).get();
        return target.getViews();
    }

    @Override
    public long getLikes(long articleId) {
        Article target = ar.findByArticleId(articleId).get();
        return target.getLikes();
    }

    @Override
    public String getWriteDate(long articleId) {
        Article target = ar.findByArticleId(articleId).get();
        return target.getDate();
    }
}
