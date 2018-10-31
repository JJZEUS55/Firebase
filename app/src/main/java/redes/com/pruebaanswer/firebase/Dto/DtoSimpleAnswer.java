package redes.com.pruebaanswer.firebase.Dto;

import android.support.annotation.NonNull;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import redes.com.pruebaanswer.realm.Dao.Dto.DtoAnswer;

public class DtoSimpleAnswer {
    private String idAnswer;
    private String idReport;
    private String indputId; //ID DE QUESTION
    private String reportIdentifier;
    private String answer;
    private String createdAt;

    public String getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(String idAnswer) {
        this.idAnswer = idAnswer;
    }

    public String getIndputId() {
        return indputId;
    }

    public void setIndputId(String indputId) {
        this.indputId = indputId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getIdReport() {
        return idReport;
    }

    public void setIdReport(String idReport) {
        this.idReport = idReport;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
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

    public void convertToSimple(DtoAnswer dtoAnswer){
        this.idAnswer = dtoAnswer.getIdAnswer();
        this.idReport = dtoAnswer.getIdReport();
        this.indputId = dtoAnswer.getIndputId(); //ID DE QUESTION
        this.reportIdentifier = dtoAnswer.getReportIdentifier();
        this.answer = dtoAnswer.getAnswer();
        this.createdAt = dtoAnswer.getCreatedAt();
    }

    @Override
    public String toString() {
        return "DtoSimpleAnswer{" +
                "idAnswer='" + idAnswer + '\'' +
                ", indputId='" + indputId + '\'' +
                ", reportIdentifier='" + reportIdentifier + '\'' +
                ", answer='" + answer + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
