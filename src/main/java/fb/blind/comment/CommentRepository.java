package fb.blind.comment;

import fb.blind.domain.comment.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {
    /**
     * @param comment 코멘트 객체 저장
     */
    void save(Comment comment);

    /**
     * @param ArticleId article 고유 id
     * @return Comment List 반환 -> article : comment 1:N relation
     */
    Optional<List<Comment>> findByArticleId(long ArticleId);

    /**
     * @param userid user 고유 id
     * @return Comment List 반환 -> user : comment 1:N relation
     */
    Optional<List<Comment>> findByUserId(long userid);

    /**
     * @param commId comment 고유 id
     */
    void delete(long commId);

}
