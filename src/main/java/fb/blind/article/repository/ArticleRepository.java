package fb.blind.article.repository;

import fb.blind.domain.article.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository {

    /**
     * @param Article 객체를 받아와 저장
     */
    void save(Article Article);

    /**
     * @param email : 사용자 id -> e-mail 활용
     * @return : null 존재 가능 -> Optional 사용
     * @return : e-mail : Article 1:N Relation
     */
    Optional<List<Article>> findByEmail(String email);

    /**
     * @param title : article 제목으로 검색 -> 검색 방법 결정 필요
     * @return title String 100% Match 외 Policy 사용 시 여러 Article 반환 가능
     */
    Optional<List<Article>> findByTitle(String title);

    /**
     * @param articleId : 게시글 제목 click 시 articleId -> PathVariable 전달
     * @return articleId Match article return
     */
    Optional<Article> findByArticleId(long articleId);

    /**
     * @param articleId article view 에서 articleId 를 알고 있음
     */
    void delete(long articleId);

    /**
     * @return articles view
     */
    Optional<List<Article>> findAll();

    /**
     * Test 용 Memory clear Method
     */
    void clear();


}
