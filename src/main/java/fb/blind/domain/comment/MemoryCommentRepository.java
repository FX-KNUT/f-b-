package fb.blind.domain.comment;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryCommentRepository implements CommentRepository{

    private static Map<Long, Comment> store = new HashMap<>();
    private static long sequence = 0L;

    /**
     * @author 김성은
     * @param comment 코멘트 객체 저장
     * @return
     */
    @Override
    public Comment save(Comment comment) {
        comment.setId(++sequence);
        store.put(comment.getId(), comment);
        return comment;
    }

    /**
     *
     * @author 김성은
     * @param commId Comment 고유 id
     * @return
     */
    @Override
    public Optional<Comment> findByCommentId(long commId) {
        return Optional.ofNullable(store.get(commId));
    }

    /**
     * @author 김성은
     * @param articleId article 고유 id
     * @return
     */
    @Override
    public List<Comment> findByArticleId(long articleId) {
        List<Comment> comments = new ArrayList<>();
        for (Comment comm : store.values()){
            if(comm.getArticleId() == articleId)
                comments.add(comm);
        }

        return comments;
    }

    /**
     * @author 김성은
     * @param userid user 고유 id
     * @return
     */
    @Override
    public List<Comment> findByUserId(long userid) {
        List<Comment> comments = new ArrayList<>();
        for (Comment comm : store.values()){
            if(comm.getUserId() == userid)
                comments.add(comm);
        }

        return comments;
    }

    /**
     * @author 김성은
     * @param commId comment 고유 id
     */
    @Override
    public void delete(long commId) {
        store.remove(commId);
    }

    /**
     * @author 김성은
     */
    @Override
    public void clear(){
        store.clear();
    }
}
