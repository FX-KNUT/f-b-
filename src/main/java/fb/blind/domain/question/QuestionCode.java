package fb.blind.domain.question;

import lombok.Data;

@Data
public class QuestionCode {

    private String displayName;

    public QuestionCode(String displayName) {
        this.displayName = displayName;
    }
}
