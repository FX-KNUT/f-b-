package fb.blind.domain.comment;

import fb.blind.domain.comment.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {
    /**
     * @param comment 코멘트 객체 저장
     */
    Comment save(Comment comment);

    /**
     * @param commId Comment 고유 id
     * @return Comment 반환
     */
    Optional<Comment> findByCommentId(long commId);

    /**
     * @param articleId article 고유 id
     * @return Comment List 반환 -> article : comment 1:N relation
     */
    List<Comment> findByArticleId(long articleId);

    /**
     * @param userid user 고유 id
     * @return Comment List 반환 -> user : comment 1:N relation
     */
    List<Comment> findByUserId(long userid);

    /**
     * @param commId comment 고유 id
     */
    void delete(long commId);

    void clear();

}
