package fb.blind.mark.repository;

import fb.blind.domain.article.Article;
import fb.blind.domain.mark.Mark;

import java.util.List;

public interface MarkRepository {
    /**
     * @param mark mark 객체 저장
     */
    Mark save(Mark mark);

    /**
     * @param userId user 고유 id
     * @return mark list return
     */
    List<Mark> findByUserId(long userId);

    List<Mark> findByArticleId(long articleId);
    /**
     * @param mark mark 객체 -> reversion 필요
     */
    void delete(Mark mark);

    /**
     * test 용
     */
    void clear();

}
