package utilTest.data.dataForQuestions;

import java.util.HashMap;
import java.util.Map;
public class QuestionBody {
    public static Map<Integer,String> questions = new HashMap<>();
    static {
        questions.put(1,"Ты встал рано утром чтобы всё было в идеале. Почистил ли ты зубы?\n");
        questions.put(2, "Ты выпил чаю, выбрал наряд. Будешь причесываться?");
        questions.put(3, "Ты решил купить цветы. Купить их рядом с домом или на месте?\n");
        questions.put(4, "Метро или такси? \n");
        questions.put(5, "Ты приехал за час до свидания.\n");
    }
}
