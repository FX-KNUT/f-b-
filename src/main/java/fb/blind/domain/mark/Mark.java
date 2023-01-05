package fb.blind.domain.mark;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mark {
    private long articleId;
    private long userId;
    private String name;

    public Mark(long articleId, long userId, String name) {
        this.articleId = articleId;
        this.userId = userId;
        this.name = name;
    }
}
