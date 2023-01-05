package fb.blind.domain.question;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Question {
    private String question;
    private String answer;
    private long userId;

    public Question(String question, String answer, long userId) {
        this.question = question;
        this.answer = answer;
        this.userId = userId;
    }
}
