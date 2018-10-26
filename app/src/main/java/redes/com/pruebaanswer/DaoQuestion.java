package redes.com.pruebaanswer;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class DaoQuestion {
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;

    public DaoQuestion() {
        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference("Seccion");
    }

    private List<DtoQuestion> selectFirebase() {
        List<DtoQuestion> dtoQuestionList = new ArrayList<>();
        mDatabase.

        return dtoQuestionList;
    }

    private int insertFirebase(DtoReport dtoReport, DtoAnswer dtoAnswer) {
        int resp = 0;
        mDatabase.child("reports").child("reportIdentifier" + dtoReport.getReportIdentifier()).child("answer").child("id_answer" + dtoAnswer.getIdAnswer()).setValue(dtoAnswer);

        return resp;
    }


    private int deleteFirebase() {
        int resp = 0;


        return resp;
    }


    private int updateFirebase(DtoAnswer dtoAnswer) {
        int resp = 0;


        return resp;
    }

}
