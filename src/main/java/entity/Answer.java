package entity;

public class Answer{
    private int id;
    private String answerBody;
    private long nextQuestionId;
    private long nextEndPointId;
    private boolean isYourSmellGood = true;


    public Answer(int id, String answerBody, long nextQuestionId) {
        this.id = id;
        this.answerBody = answerBody;
        this.nextQuestionId = nextQuestionId;
    }

    public long getNextEndPointId() {
        return nextEndPointId;
    }

    public long getNextQuestionId() {
        return nextQuestionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswerBody() {
        return answerBody;
    }


}
