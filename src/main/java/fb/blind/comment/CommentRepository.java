package fb.blind.comment;

import fb.blind.domain.comment.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {
    void save(Comment comment);
    Optional<List<Comment>> findByArticleId(long ArticleId);
    Optional<List<Comment>> findByUserId(long userid);
    void delete(long commId);

}
