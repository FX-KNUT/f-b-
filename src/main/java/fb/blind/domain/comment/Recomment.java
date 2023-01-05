package fb.blind.domain.comment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Recomment {

    /**
     * id: comment 고유 id
     * commId : 게시물 id
     * userid : comment 작성자 id
     * comm : 댓글 내용
     * date: 댓글 작성 시간
     * likes: 좋아요 server binding
     */
    private long id;
    private long commId;
    private long userId;
    private String comm;
    private String date;
    private long likes;

    public Recomment(long commId, long userId, String comm, String date) {
        this.commId = commId;
        this.userId = userId;
        this.comm = comm;
        this.date = date;
    }

}
