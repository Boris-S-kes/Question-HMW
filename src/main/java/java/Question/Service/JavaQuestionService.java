package java.Question.Service;

import org.springframework.stereotype.Service;

import java.Question.Question;
import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question add(String question,String answer) {
        return add(new Question(question, answer));
    }
    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }
    @Override
    public Question remove(Question question) {
        return questions.remove(question) ? question : null;
    }
    @Override
    public Collection<Question> getAll() {
        return Set.copyOf(questions);
    }
    @Override
    public Question getRandomQuestion () {
        if (questions.isEmpty()) {
            return null;
        }
        List<Question> list = List.copyOf(questions);
        return list.get(random.nextInt(list.size()));
        }

    }


