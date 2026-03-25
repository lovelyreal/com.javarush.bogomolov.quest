package entity;

public class Answer{
    private long id;
    private String answerBody;
    private long nextQuestionId;
    private long nextEndPointId;
    private boolean isYourSmellGood = true;


    public Answer(long id, String answerBody, long nextQuestionId) {
        this.id = id;
        this.answerBody = answerBody;
        this.nextQuestionId = nextQuestionId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnswerBody() {
        return answerBody;
    }

    public void setAnswerBody(String answerBody) {
        this.answerBody = answerBody;
    }

    public long getNextQuestionId() {
        return nextQuestionId;
    }

    public void setNextQuestionId(long nextQuestionId) {
        this.nextQuestionId = nextQuestionId;
    }

    public long getNextEndPointId() {
        return nextEndPointId;
    }

    public void setNextEndPointId(long nextEndPointId) {
        this.nextEndPointId = nextEndPointId;
    }

    public boolean isYourSmellGood() {
        return isYourSmellGood;
    }

    public void setYourSmellGood(boolean yourSmellGood) {
        isYourSmellGood = yourSmellGood;
    }
}
