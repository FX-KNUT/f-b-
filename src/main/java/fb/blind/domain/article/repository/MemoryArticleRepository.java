package fb.blind.domain.article.repository;

import fb.blind.domain.article.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class MemoryArticleRepository implements ArticleRepository {

    private static Map<Long, Article> store = new HashMap<>();

    /**
     * article id  -> server 에서 자동 입력
     */
    private static long Sequence = 0L;

    /**
     * @author 김성은,신영운
     * @param article 객체를 받아와 저장
     */
    @Override
    public Article save(Article article) {
        article.setId(++Sequence);
        store.put(article.getId(),article);
        return article;
    }

    /**
     * 구현 필요
     * @author 김성은,신영운
     * @param email : 사용자 id -> e-mail 활용
     * @return
     */
    @Override
    public List<Article> findByEmail(String email) {
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
        return new ArrayList<>(store.values());
    }

    /**
     * @author 김성은,신영운
     * test 용
     */
    @Override
    public void clear() {
        store.clear();
    }

    @Override
    public Article updateArticle(Article update) {
        Article target = store.get(update.getId());
        setValues(update, target);

        return store.get(update.getId());
    }

    private static void setValues(Article update, Article target) {
        target.setTitle(update.getTitle());
        target.setBody(update.getBody());
        target.setDate(update.getDate());
        target.setFileName(update.getFileName());
    }

}
