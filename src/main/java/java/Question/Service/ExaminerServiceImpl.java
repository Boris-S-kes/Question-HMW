package java.Question.Service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.Question.Question;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Set<Question> getQuestion(int amount) {
        Set<Question> avialable = new HashSet<>(questionService.getAll());

        if (amount < 0 || amount > avialable.size()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "запрошено больше вопросов, чем есть в сервисе");
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            result.add(questionService.getRandomQuestion());
        }
        return result;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        return List.of();
    }
}








