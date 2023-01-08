package fb.blind.domain.kind;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Kind {
    /**
     * id = 게시판 고유 id
     * kindName = 게시판 이름
     */
    private long id;
    private String kindName;

    public Kind() {}

    public Kind(String kindName) {
        this.kindName = kindName;
    }
}
