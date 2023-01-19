package fb.blind.domain.article.service;

import fb.blind.domain.article.repository.ArticleRepository;
import fb.blind.domain.article.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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

        Article target = ar.findByArticleId(article.getId()).get();
        target.setTitle(article.getTitle());
        target.setBody(article.getBody());
        target.setDate(article.getDate());
        target.setFileName(article.getFileName());
        return target;
    }

    @Override
    public void deleteArticle(long articleId) {
        ar.delete(articleId);
    }

    @Override
    public List<Article> articleList(long kindId) {
        return findByKindId(kindId);
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

    @Override
    public Optional<Article> findByTitle(String title) {
        return ar.findAll().stream().filter(m -> m.getTitle().equals(title)).findAny();
    }

    @Override
    public List<Article> findByKindId(long kindId) {
        
        List<Article> result = new ArrayList<>();
        List<Article> findList = ar.findAll();
        for (Article article : findList) {
            if(article.getKindId() == kindId){
                result.add(article);
            }
        }

        return result;
    }

    @Override
    public void insertBoard(Article article, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        if (ObjectUtils.isEmpty(multipartHttpServletRequest) == false){
            Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
            String name;
            while(iterator.hasNext()){
                name = iterator.next();
                log.debug("file tag name : " + name);
                List<MultipartFile> list = multipartHttpServletRequest.getFiles(name);
                for (MultipartFile multipartFile : list){
                    log.debug("start file information");
                    log.debug("file name : " + multipartFile.getOriginalFilename());
                    log.debug("file size : " + multipartFile.getSize());
                    log.debug("file content type : " + multipartFile.getContentType());
                    log.debug("end file information. \n");
                }
            }
        }
    }

}
