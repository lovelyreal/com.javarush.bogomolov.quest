package utilTest.data.dataForAnswers;

import java.util.HashMap;
import java.util.Map;

public class AnswersBody {
    public static Map<Integer, String> answersBody = new HashMap<>();
    static {
        answersBody.put(11, "Да");
        answersBody.put(12, "Нет");
        answersBody.put(21, "Да");
        answersBody.put(22, "Нет");
        answersBody.put(31, "Купить цветы рядом с домом");
        answersBody.put(32, "Купить цветы на месте");
        answersBody.put(41, "Метро");
        answersBody.put(42, "Такси");
        answersBody.put(51, "Подождать");
        answersBody.put(52, "Отойти в ближайшую кофейню и подождать там");
    }
}
