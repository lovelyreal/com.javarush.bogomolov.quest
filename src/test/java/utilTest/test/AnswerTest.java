package utilTest.test;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entity.Answer;
import org.junit.jupiter.api.Test;
import util.AnswerUtil;
import utilTest.data.dataForAnswers.AnswersBody;
import utilTest.data.dataForAnswers.AnswersId;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnswerTest {
    @Test
    public void extractingAnswersTest(){
        for (int i = 0; i < AnswersId.answersId.length; i++) {
            Answer testAnswer = AnswerUtil.getAnswerById(AnswersId.answersId[i]);
            assert testAnswer != null;
            assertEquals(testAnswer.getAnswerBody(), AnswersBody.answersBody.get(AnswersId.answersId[i]));
        }
    }
}
