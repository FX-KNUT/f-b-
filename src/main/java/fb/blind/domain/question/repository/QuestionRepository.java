package fb.blind.domain.question.repository;

import fb.blind.domain.question.Question;

public interface QuestionRepository {

    Question save(Question question);

    Question findByUserId(Long UserId);

}
