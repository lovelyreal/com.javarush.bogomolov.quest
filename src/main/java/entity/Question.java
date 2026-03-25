package entity;

public class Question implements Variant {
    private long id;
    private String questionBody;
    private long[] nextAnswerId;

    public Question(long id, String questionBody, long[] nextAnswerId) {
        this.id = id;
        this.questionBody = questionBody;
        this.nextAnswerId = nextAnswerId;
    }
}
