package fb.blind.comment;

import fb.blind.domain.comment.Comment;
import fb.blind.domain.comment.Recomment;

import java.util.List;
import java.util.Optional;

public interface RecommentRepository {
    /**
     * @param comment comment 객체 저장
     */
    void save(Recomment comment);

    /**
     * @param commId comment 고유 id
     * @return recomment list 반환
     */
    Optional<List<Recomment>> findByCommId(long commId);

    /**
     * @param userid user 고유 id
     * @return Recomment List 반환
     */
    Optional<List<Recomment>> findByUserId(long userid);

    /**
     * @param commId comment  고유 id
     */
    void delete(long commId);

}
