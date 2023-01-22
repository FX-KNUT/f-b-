package fb.blind.domain.comment;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemmoryRecommentRepository implements RecommentRepository {
    private static Map<Long, Recomment> store = new HashMap<>();

    private long Sequence = 0L;

    /**
     * @author 김민기
     * @param recomment comment 객체 저장
     */
    @Override
    public void save(Recomment recomment) {
        recomment.setId(++Sequence);
        long commentId = recomment.getId();
        store.put(commentId,recomment);
    }

    /**
     * @author 김민기
     * @param commId comment 고유 id
     * @return
     */
    @Override
    public List<Recomment> findByCommId(long commId) {
        List<Recomment> recomments = new ArrayList<>();
        for(Recomment recom : store.values()){
            if (recom.getCommId() == commId)
                recomments.add(recom);
        }
        return recomments;
    }

    /**
     * @author 김민기
     * @param userId comment 고유 id
     * @return
     */
    @Override
    public List<Recomment> findByUserId(long userId) {
        List<Recomment> recomments = new ArrayList<>();
        for(Recomment recom : store.values()){
            if (recom.getUserId() == userId)
                recomments.add(recom);
        }
        return recomments;
    }

    @Override
    public void delete(long commId) {
        store.remove(commId);
    }
}
