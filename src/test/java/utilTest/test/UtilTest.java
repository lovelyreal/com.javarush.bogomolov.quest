package utilTest.test;

import entity.Answer;
import entity.EndPoint;
import entity.Question;
import org.junit.jupiter.api.Test;
import util.Data;
import util.StepUtil;
import utilTest.data.dataForAnswers.AnswersBody;
import utilTest.data.dataForAnswers.AnswersId;
import utilTest.data.dataForEndPoints.EndPointBody;
import utilTest.data.dataForEndPoints.EndPointId;
import utilTest.data.dataForQuestions.QuestionBody;
import utilTest.data.dataForQuestions.QuestionsId;

import static junit.framework.Assert.assertEquals;
public class UtilTest {
    @Test
    public void test_util_test(){
        int testId = 0;
        String utilAnswerBody = ((Answer) StepUtil.getStepById(AnswersId.answersId[testId], Data.answers)).getAnswerBody();
        String testAnswerBody = AnswersBody.answersBody.get(AnswersId.answersId[testId]);
        String utilQuestionBody = ((Question) StepUtil.getStepById(QuestionsId.questionsId[testId], Data.questions)).getQuestionBody();;
        String testQuestionBody = QuestionBody.questions.get(QuestionsId.questionsId[testId]);
        String utilEndPointBody = ((EndPoint) StepUtil.getStepById(EndPointId.endPointId[testId], Data.endPoints)).getText();;
        String testEndPointBody = EndPointBody.endPointBody.get(EndPointId.endPointId[testId]);
            assertEquals(utilAnswerBody, testAnswerBody);
            assertEquals(utilQuestionBody, testQuestionBody);
            assertEquals(utilEndPointBody, utilEndPointBody);

    }
}
