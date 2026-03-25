package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entity.Answer;
import entity.EndPoint;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

public class EndPointService {
    public static List<EndPoint> getEndPoints() {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<EndPoint>>() {
        }.getType();
        InputStreamReader reader = new InputStreamReader(Objects.requireNonNull(AnswerService.class.getResourceAsStream("/endPointData.json")));
        return gson.fromJson(reader, listType);
    }

    public static EndPoint getEndPointById(int id) {
        return getEndPoints().stream()
                .filter(q -> q.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
