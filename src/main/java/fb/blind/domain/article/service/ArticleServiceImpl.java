package fb.blind.domain.article.service;

import fb.blind.domain.article.repository.ArticleRepository;
import fb.blind.domain.article.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.apache.coyote.http11.Constants.a;

@Slf4j
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
        Optional<Article> target = ar.findByArticleId(article.getId());

        if(target.isEmpty()){
            return null;
        }

        Article update = new Article(target.get().getId(), article.getTitle(), article.getBody(), article.getDate(),article.getFileName());

        return ar.updateArticle(update);
    }

    /**
     * article 삭제
     * @param articleId article 고유 id
     */
    @Override
    public void deleteArticle(long articleId) {
        ar.delete(articleId);
    }

    /**
     *
     * @param kindId
     * @return
     */
    @Override
    public List<Article> articleList(long kindId) {
        return findByKindId(kindId);
    }

    /**
     *
     * @param articleId article 고유 id
     * @return
     */
    @Override
    public String getURL(long articleId) {
        return "http://localhost8080/articles/" + articleId;
    }

    /**
     *
     * @param articleId article 고유 id
     * @return
     */
    @Override
    public long getViews(long articleId) {
        Article target = ar.findByArticleId(articleId).get();
        return target.getViews();
    }

    /**
     *
     * @param articleId article 고유 id
     * @return
     */
    @Override
    public long getLikes(long articleId) {
        Article target = ar.findByArticleId(articleId).get();
        return target.getLikes();
    }

    /**
     *
     * @param articleId article 고유 id
     * @return
     */
    @Override
    public String getWriteDate(long articleId) {
        Article target = ar.findByArticleId(articleId).get();
        return target.getDate();
    }

    /**
     * @param title : article 제목으로 검색 -> 검색 방법 결정 필요
     * @return
     * @author 김성은, 신영운
     * @version v0_1 : title 100% 검사
     */
    @Override
    public Optional<Article> findByTitle(String title) {
        return ar.findAll().stream().filter(m -> m.getTitle().equals(title)).findAny();
    }

    /**
     *
     * @param kindId
     * @return
     */
    @Override
    public List<Article> findByKindId(long kindId) {
        
        List<Article> result = new ArrayList<>();
        //List<Article> findList = ar.findAll();
        ar.findAll().forEach(a -> {
            if(a.getKindId() == kindId){
                result.add(a);
            }
        });
//        for (Article article : findList) {
//            if(article.getKindId() == kindId){
//                result.add(article);
//            }
//        }

        return result;
    }

}
