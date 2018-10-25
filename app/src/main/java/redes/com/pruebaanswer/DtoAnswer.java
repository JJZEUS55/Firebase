package redes.com.pruebaanswer;

public class DtoAnswer {
    private int idAnswer;
    private int indputId; //ID DE QUESTION
    private String reportIdentifier;
    private String answer;
    private long createdAt;

    public int getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(int idAnswer) {
        this.idAnswer = idAnswer;
    }

    public int getIndputId() {
        return indputId;
    }

    public void setIndputId(int indputId) {
        this.indputId = indputId;
    }

    public String getReportIdentifier() {
        return reportIdentifier;
    }

    public void setReportIdentifier(String reportIdentifier) {
        this.reportIdentifier = reportIdentifier;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
}
