import org.junit.jupiter.api.Test;

import java.Question.Question;
import java.Question.Service.JavaQuestionService;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {
    private final JavaQuestionService service = new JavaQuestionService();

    @Test
    void addQuestionAndIgnoreDuplicate() {
        Question question = new Question("Что такое JVM?", "Виртуальная машина Java");
        service.add(question);
        service.add(question);
        assertEquals(1, service.getAll().size());
    }

    @Test
    void returnsNullWhenGettingRandomQuestionFromEmptyService() {
        assertNull(service.getRandomQuestion());

    }

    @Test
    void removeQuestion() {
        Question question = service.add("Что такое JVM?", "Виртуальная машина Java");
        assertEquals(question, service.remove(question));
        assertTrue(service.getAll().isEmpty());
    }

    @Test
    void returnsNullWhenRemovingMissingQuestion() {
        assertNull(service.remove(new Question("Нет такого вопроса", "Ответ")));
    }

    @Test
    void returnsRandomQuestionWhenCollectionIsNotEmpty() {
        Question question = service.add("Что такое JVM?", "Виртуальная машина Java");
        assertEquals(question, service.getRandomQuestion());
    }
}



