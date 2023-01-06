package fb.blind.article.service;

import fb.blind.domain.article.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    /**
     * @param article article 신규 작성 하기
     */
    void addArticle(Article article);

    /**
     * @param articleId article 고유 id
     * @return article 반환
     */
    Optional<Article> readArticle(long articleId);

    /**
     * @param articleId article 고유 id
     * @return update 된 article 반환
     */
    Article updateArticle(long articleId);

    /**
     * @param articleId article 고유 id
     */
    void deleteArticle(long articleId);

    /**
     * @return article 전체 조회
     */
    Optional<List<Article>> articleList();

    /**
     * @param articleId article 고유 id
     * @return URL 반환 -> resolver 를 통해 url을 만들어주는 과정 필요
     */
    String getURL(long articleId);

    /**
     * @param articleId article 고유 id
     * @return 조회수 반한
     */
    int getViews(long articleId);

    /**
     * @param articleId article 고유 id
     * @return 좋아요 수 반환
     */
    int getLikes(long articleId);

    /**
     * @param articleId article 고유 id
     * @return 작성일 반환
     */
    String getWriteDate(long articleId);

}
