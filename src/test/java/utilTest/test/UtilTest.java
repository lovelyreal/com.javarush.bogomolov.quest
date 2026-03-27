package utilTest.test;

import entity.Answer;
import org.junit.jupiter.api.Test;
import util.Data;
import util.StepUtil;
import utilTest.data.dataForAnswers.AnswersBody;
import utilTest.data.dataForAnswers.AnswersId;

import static junit.framework.Assert.assertEquals;
public class UtilTest {
    @Test
    public void test_util_test(){
        int testId = 0;
        String utilAnswerBody = ((Answer) StepUtil.getStepById(AnswersId.answersId[testId], Data.answers)).getAnswerBody();
        String testAnswerBody = AnswersBody.answersBody.get(AnswersId.answersId[testId]);
            assertEquals(utilAnswerBody, testAnswerBody);

    }
}
