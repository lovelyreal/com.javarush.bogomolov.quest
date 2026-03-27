package utilTest.test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entity.Answer;
import entity.EndPoint;
import org.junit.jupiter.api.Test;
import utilTest.data.dataForAnswers.AnswersBody;
import utilTest.data.dataForAnswers.AnswersId;
import utilTest.data.dataForEndPoints.EndPointBody;
import utilTest.data.dataForEndPoints.EndPointId;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

//public class EndPointTest {
//    @Test
//    public void extractingEndpointsTest(){
//        for (int i = 0; i < EndPointId.endPointId.length; i++) {
//            EndPoint testEndPoint = EndPointUtil.getEndPointById(EndPointId.endPointId[i]);
//            assert testEndPoint != null;
//            assertEquals(testEndPoint.getText(), EndPointBody.endPointBody.get(EndPointId.endPointId[i]));
//        }
//    }
//}
