package fb.blind.comment;

import fb.blind.domain.comment.Comment;
import fb.blind.domain.comment.Recomment;

import java.util.List;
import java.util.Optional;

public interface RecommentRepository {
    void save(Recomment comment);
    Optional<List<Recomment>> findByCommId(long commId);
    Optional<List<Recomment>> findByUserId(long userid);
    void delete(long commId);

}
