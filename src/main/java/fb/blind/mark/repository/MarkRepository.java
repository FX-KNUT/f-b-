package fb.blind.mark.repository;

import fb.blind.domain.article.Article;
import fb.blind.domain.mark.Mark;

import java.util.List;

public interface MarkRepository {
    void save(Mark mark);
    /*user --> info Mark Title List*/
    List<Mark> findByUserId(long userid);
    /* view 설계 시 수정 예정*/
    void delete(Mark mark);

}
