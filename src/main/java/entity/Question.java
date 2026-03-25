package entity;

public class Question{
    private long id;
    private String questionBody;
    private long[] nextAnswerId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestionBody() {
        return questionBody;
    }

    public void setQuestionBody(String questionBody) {
        this.questionBody = questionBody;
    }

    public long[] getNextAnswerId() {
        return nextAnswerId;
    }

    public void setNextAnswerId(long[] nextAnswerId) {
        this.nextAnswerId = nextAnswerId;
    }
}
