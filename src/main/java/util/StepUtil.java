package util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entity.Answer;
import entity.EndPoint;
import entity.Question;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class StepUtil {
    private static final Gson gson = new Gson();
    private static <T> List<T> getStep(String data) {
        Type listType = null;
        if(data.equals(Data.questions)) {
            listType = new TypeToken<List<Question>>() {
            }.getType();
        } else if(data.equals(Data.answers)) {
            listType = new TypeToken<List<Answer>>() {
            }.getType();
        } else if(data.equals(Data.endPoints)) {
            listType = new TypeToken<List<EndPoint>>() {
            }.getType();
        } else {
            listType = new TypeToken<List<Question>>() {
            }.getType();
        }
        InputStreamReader reader = new InputStreamReader(Objects.requireNonNull(StepUtil.class.getResourceAsStream(data)));
        return gson.fromJson(reader, listType);
    }

    public static Object getStepById(int id, String data) {
        if(data.equals(Data.questions)){
            Optional<Question> question = getStep(data).stream()
                    .map(q -> (Question) q)
                    .filter(q -> q.getId() == id)
                    .findFirst();
            return question.orElse(null);
        } else if(data.equals(Data.answers)) {
            Optional<Answer> answer = getStep(data).stream()
                    .map(a -> (Answer) a)
                    .filter(a -> a.getId() == id)
                    .findFirst();
            return answer.orElse(null);
        } else if(data.equals(Data.endPoints)) {
            Optional<EndPoint> endPoint = getStep(data).stream()
                    .map(e -> (EndPoint) e)
                    .filter(e -> e.getId() == id)
                    .findFirst();
            return endPoint.orElse(null);
        } else {
            return null;
        }
    }
}
