package java.Question.Service;

import java.Question.Question;
import java.util.Collection;
import java.util.Set;

public interface ExaminerService {
    Set<Question> getQuestion(int amount);

    Collection<Question> getQuestions(int amount);
}
