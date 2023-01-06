package fb.blind.domain.question;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Question {

    /**
     * @Param question e-mail 찾기용 질문
     * @Param answer e-mail 찾기용 문답
     * @Param userId user 고유 id -> FK
     */
    private String question;
    private String answer;
    private long userId;

    public Question() {}

    public Question(String question, String answer, long userId) {
        this.question = question;
        this.answer = answer;
        this.userId = userId;
    }
}
