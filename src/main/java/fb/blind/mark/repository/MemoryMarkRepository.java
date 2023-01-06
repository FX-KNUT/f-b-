package fb.blind.mark.repository;

import fb.blind.article.repository.ArticleRepository;
import fb.blind.domain.mark.Mark;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryMarkRepository implements MarkRepository{

    private Map<Long,Mark> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Mark save(Mark mark) {
        mark.setId(++sequence);
        store.put(mark.getId(),mark);
        return mark;
    }

    @Override
    public List<Mark> findByUserId(long userId) {
        List<Mark> result = new ArrayList<>();
        for (Mark mark : store.values()) {
            if(mark.getUserId() == userId){
                result.add(mark);
            }
        }
        return result;
    }

    @Override
    public List<Mark> findByArticleId(long articleId) {
        List<Mark> result = new ArrayList<>();
        for (Mark mark : store.values()) {
            if(mark.getArticleId() == articleId){
                result.add(mark);
            }
        }
        return result;
    }

    @Override
    public void delete(Mark mark) {
        store.remove(mark.getArticleId());
    }

    @Override
    public void clear() {
        store.clear();
    }
}
