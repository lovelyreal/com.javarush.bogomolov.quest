package entity;

public class Answer implements Variant {
    private long id;
    private String answerBody;
    private long nextQuestionId;

    public Answer(long id, String answerBody, long nextQuestionId) {
        this.id = id;
        this.answerBody = answerBody;
        this.nextQuestionId = nextQuestionId;
    }
}
