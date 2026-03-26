package util;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entity.Question;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

public class QuestionUtil {
    public static List<Question> getQuestions() {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Question>>() {
        }.getType();
        InputStreamReader reader = new InputStreamReader(Objects.requireNonNull(QuestionUtil.class.getResourceAsStream("/questionData.json")));
        return gson.fromJson(reader, listType);
    }

    public static Question getQuestionById(int id) {
        return getQuestions().stream()
                .filter(q -> q.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
