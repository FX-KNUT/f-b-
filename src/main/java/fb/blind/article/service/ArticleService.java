package fb.blind.article.service;

import fb.blind.domain.article.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    void addArticle(Article article);

    Optional<Article> readArticle(long articleId);

    Article updateArticle(long articleId);

    void deleteArticle(long articleId);

    Optional<List<Article>> articleList();

    String getURL(long articleId);

    int getViews(long articleId);

    int getLikes(long articleId);

    String getWriteDate(long articleId);

}
