package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entity.Answer;
import entity.Question;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

public class AnswerService {
    public static List<Answer> getAnswers() {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Answer>>() {
        }.getType();
        InputStreamReader reader = new InputStreamReader(Objects.requireNonNull(AnswerService.class.getResourceAsStream("/answersData.json")));
        return gson.fromJson(reader, listType);
    }

    public static Answer getAnswerById(int id) {
        return getAnswers().stream()
                .filter(q -> q.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
