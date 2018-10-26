package redes.com.pruebaanswer;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class DaoAnswer {
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;

    public DaoAnswer() {
        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference();
    }

    private List<DtoAnswer> selectFirebase() {
        List<DtoAnswer> dtoAnswerList = new ArrayList<>();


        return dtoAnswerList;
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
