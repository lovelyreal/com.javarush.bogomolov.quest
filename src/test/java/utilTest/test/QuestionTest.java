package utilTest.test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entity.Answer;
import entity.Question;
import org.junit.jupiter.api.Test;
import util.AnswerUtil;
import util.QuestionUtil;
import utilTest.data.dataForAnswers.AnswersBody;
import utilTest.data.dataForAnswers.AnswersId;
import utilTest.data.dataForQuestions.QuestionBody;
import utilTest.data.dataForQuestions.QuestionsId;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionTest {
    @Test
    public void extractingQuestionsTest(){
        for (int i = 0; i < QuestionsId.questionsId.length; i++) {
            Question testQuestion = QuestionUtil.getQuestionById(QuestionsId.questionsId[i]);
            assert testQuestion != null;
            assertEquals(testQuestion.getQuestionBody(), QuestionBody.questions.get(QuestionsId.questionsId[i]));
        }
    }
}
