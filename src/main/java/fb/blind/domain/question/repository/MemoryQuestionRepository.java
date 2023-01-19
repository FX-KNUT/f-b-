package fb.blind.domain.question.repository;

import fb.blind.domain.question.Question;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemoryQuestionRepository implements QuestionRepository{

    private static Map<Long,Question> store = new HashMap<>();

    @Override
    public Question save(Question question) {
        return store.put(question.getUserId(),question);
    }

    @Override
    public Question findByUserId(Long UserId) {
        return store.get(UserId);
    }
}
