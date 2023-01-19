package fb.blind.domain.article.repository;

import fb.blind.domain.article.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository {

    /**
     * @author 김성은,신영운
     * @param Article 객체를 받아와 저장
     */
    Article save(Article Article);

    /**
     * @author 김성은,신영운
     * @param email : 사용자 id -> e-mail 활용
     * @return : null 존재 가능 -> Optional 사용
     * @return : e-mail : Article 1:N Relation
     */
    List<Article> findByEmail(String email);

    /**
     * @author 김성은,신영운
     * @param title : article 제목으로 검색 -> 검색 방법 결정 필요
     * @return title String 100% Match 외 Policy 사용 시 여러 Article 반환 가능
     */

    /**
     * @author 김성은,신영운
     * @param articleId : 게시글 제목 click 시 articleId -> PathVariable 전달
     * @return articleId Match article return
     */
    Optional<Article> findByArticleId(long articleId);
    /**
     * @author 김민기
     * @param userId : 본인 게시판 click 시 userId -> PathVariable 전달
     * @return UserId Match article return
     */
    List<Article> findByUserId(long userId);

    /**
     * @author 김성은,신영운
     * @param articleId article view 에서 articleId 를 알고 있음
     */
    void delete(long articleId);

    /**
     * @author 김성은,신영운
     * @return articles view
     */
    List<Article> findAll();

    /**
     * @author 김성은,신영운
     * Test 용 Memory clear Method
     */
    void clear();


}
