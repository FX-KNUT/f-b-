package fb.blind.domain.mark;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mark {

    /**
     * @Param articleId : article 고유 id -> FK
     * @Param userId : user 고유 id -> FK
     * @Param name : mark 이름
     */
    private long articleId;
    private long userId;
    private String name;

    public Mark() {}

    public Mark(long articleId, long userId, String name) {
        this.articleId = articleId;
        this.userId = userId;
        this.name = name;
    }
}
