package fb.blind.article.repository;

import fb.blind.domain.article.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Slf4j
@Repository
public class MemoryArticleRepository implements ArticleRepository {

    private final Map<Long, Article> store = new HashMap<>();
    private long Sequence = 0L;
    /**
     * @author 김성은,신영운
     * @param Article 객체를 받아와 저장
     * 작성 레벨 --> ???
     * 변수 담아서 갈래? -> 직접 매서드 호출
     */
    @Override
    public void save(Article Article) {
        Article.setId(++Sequence);
        long articleId = Article.getId();
        store.put(articleId,Article);
    }

    /**
     * @author 김성은,신영운
     * User 만들고 update 필요
     * @param email : 사용자 id -> e-mail 활용
     * @return
     */
    @Override
    public List<Article> findByEmail(String email) {
        return null;
    }

    /**
     *
     * @param title : article 제목으로 검색 -> 검색 방법 결정 필요
     * @return
     * @author 김성은, 신영운
     * @version v0_1 : title 100% 검사
     */
    @Override
    public Article findByTitle(String title) {
        for (Article article : store.values()) {
            if(article.getTitle() == title){
                return article;
            }
        }
      return null;
    }

    /**
     * @author 김성은,신영운
     * @param articleId : 게시글 제목 click 시 articleId -> PathVariable 전달
     * @return
     */
    @Override
    public Optional<Article> findByArticleId(long articleId) {
        return Optional.ofNullable(store.get(articleId));
    }

    /**
     * @author 김성은,신영운
     * @param articleId article view 에서 articleId 를 알고 있음
     */
    @Override
    public void delete(long articleId) {
        store.remove(articleId);
    }

    /**
     * @author 김성은,신영운
     * @return
     */
    @Override
    public List<Article> findAll() {
        return new ArrayList<Article>(store.values());
    }

    /**
     * @author 김성은,신영운
     * test 용
     */
    @Override
    public void clear() {
        store.clear();
    }

    @PostConstruct
    public void setTestData(){
        Article arA = new Article("testA", "test", "2023-01-06", null);
        Article arB = new Article("testB", "test", "2023-01-06", null);
        Article arC = new Article("testC", "test", "2023-01-06", null);
        store.put(997L,arA);
        store.put(998L,arB);
        store.put(999L,arC);
    }

}
