import net.bytebuddy.agent.VirtualMachine;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import java.Question.Service.ExaminerServiceImpl;
import java.Question.Service.JavaQuestionService;

import static org.junit.jupiter.api.Assertions.*;

public class ExaminServiceImplTest {
    @Test
    void returnsRequestedNumberOfUniqueQuestions() {
        JavaQuestionService questionService = new JavaQuestionService();
        questionService.add("вопрос 1", "ответет 1");
        questionService.add("вопрос 2", "ответ 2");
        questionService.add("вопрос 3", " отыет 3");
        ExaminerServiceImpl examiner = new ExaminerServiceImpl(questionService);
        assertEquals(2, examiner.getQuestion(2).size());
    }
    @Test
    void returnsEmptySetForZeroAmount() {
        JavaQuestionService questionService = new JavaQuestionService();
        ExaminerServiceImpl examiner = new ExaminerServiceImpl(questionService);
        assertTrue(examiner.getQuestion(0).isEmpty());
    }
    @Test
    void  requesteNumberOfQuestionsExceedsTheTotalNumberOfAvailableQuestions() {
        JavaQuestionService questionService = new JavaQuestionService();
        questionService.add("вопрос","ответ");
        ExaminerServiceImpl examiner = new ExaminerServiceImpl(questionService);
        ResponseStatusException exception = assertThrows(
         ResponseStatusException.class,
                () -> examiner.getQuestion(2));
        assertEquals(400,exception.getStatusCode().value());




    }
}
