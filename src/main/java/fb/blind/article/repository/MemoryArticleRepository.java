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
     * @param article 객체를 받아와 저장
     * 작성 레벨 --> ???
     * 변수 담아서 갈래? -> 직접 매서드 호출
     */
    @Override
    public Article save(Article article) {
        article.setId(++Sequence);
        long articleId = article.getId();
        store.put(articleId,article);
        return article;
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

    @Override
    public List<Article> findByKindId(long kindId) {
        List<Article> articles = new ArrayList<>(store.values());
        List<Article> result = new ArrayList<>();
        for (Article article : articles) {
            if(article.getKindId()== kindId){
                result.add(article);
            }
        }
        return result;
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
        Article arA = new Article("testA", "test", "2023-01-06", null,"shin",996L);
        Article arB = new Article("testB", "test", "2023-01-06", null,"shin",996L);
        Article arC = new Article("testC", "test", "2023-01-06", null,"shin",996L);
        Article arD = new Article("testD", "test", "2023-01-06", null,"shin",997L);
        Article arE = new Article("testE", "test", "2023-01-06", null,"shin",997L);
        Article arF = new Article("testF", "test", "2023-01-06", null,"shin",997L);
        Article arG = new Article("testG", "test", "2023-01-06", null,"shin",998L);
        Article arH = new Article("testH", "test", "2023-01-06", null,"shin",998L);
        Article arI = new Article("testI", "test", "2023-01-06", null,"shin",998L);


        Article arJ = new Article("testJ", "test", "2023-01-06", null,"shin",999L);
        Article arK = new Article("testK", "test", "2023-01-06", null,"shin",999L);
        Article arL = new Article("testL", "test", "2023-01-06", null,"shin",999L);

        arA.setId(988L);
        arB.setId(989L);
        arC.setId(990L);
        arD.setId(991L);
        arE.setId(992L);
        arF.setId(993L);
        arG.setId(994L);
        arH.setId(995L);
        arI.setId(996L);
        arJ.setId(997L);
        arK.setId(998L);
        arL.setId(999L);

        store.put(988L,arA);
        store.put(989L,arB);
        store.put(990L,arC);
        store.put(991L,arD);
        store.put(992L,arE);
        store.put(993L,arF);
        store.put(994L,arG);
        store.put(995L,arH);
        store.put(996L,arI);
        store.put(997L,arJ);
        store.put(998L,arK);
        store.put(999L,arL);
    }

}
