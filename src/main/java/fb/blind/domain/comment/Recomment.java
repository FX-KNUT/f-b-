package fb.blind.domain.comment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Recomment {

    /**
     * @Param id: comment 고유 id
     * @Param commId : 게시물 id
     * @Param userid : comment 작성자 id
     * @Param comm : 댓글 내용
     * @Param date: 댓글 작성 시간
     * @Param likes: 좋아요 server binding
     */
    private long id;
    private long commId;
    private long userId;
    private String comm;
    private String date;
    private long likes;

    public Recomment() {}

    public Recomment(long commId, long userId, String comm, String date) {
        this.commId = commId;
        this.userId = userId;
        this.comm = comm;
        this.date = date;
    }

}
