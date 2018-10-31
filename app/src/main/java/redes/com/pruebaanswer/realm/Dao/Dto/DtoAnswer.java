package redes.com.pruebaanswer.realm.Dao.Dto;

import android.support.annotation.NonNull;

import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;
import redes.com.pruebaanswer.firebase.Dto.DtoSimpleAnswer;

public class DtoAnswer extends RealmObject {
    @PrimaryKey
    @NonNull
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

    public DtoSimpleAnswer convertToSimple(){
        DtoSimpleAnswer dtoSimpleAnswer = new DtoSimpleAnswer();
        dtoSimpleAnswer.setAnswer(this.idAnswer);
        dtoSimpleAnswer.setIdReport(this.idReport);
        dtoSimpleAnswer.setIndputId(this.indputId);
        dtoSimpleAnswer.setReportIdentifier(this.reportIdentifier);
        dtoSimpleAnswer.setAnswer(this.answer);
        dtoSimpleAnswer.setCreatedAt(this.createdAt);

        return dtoSimpleAnswer;
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
