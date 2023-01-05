package fb.blind.article.repository;

import fb.blind.domain.article.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository {
    void save(Article Article);

    Optional<Article> findByEmail(String email);

    Optional<List<Article>> findByTitle(String title);

    void delete(long articleId);

    Optional<List<Article>> findAll();

    /*구현체에서 clear 만들것*/


}
