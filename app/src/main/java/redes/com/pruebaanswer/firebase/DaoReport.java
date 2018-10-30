package redes.com.pruebaanswer.firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import redes.com.pruebaanswer.realm.Dao.Dto.DtoAnswer;
import redes.com.pruebaanswer.realm.Dao.Dto.DtoReport;

public class DaoReport {
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;

    public DaoReport() {
        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference();
    }

    private List<DtoAnswer> selectFirebase() {
        List<DtoAnswer> dtoAnswerList = new ArrayList<>();


        return dtoAnswerList;
    }

    private int insertFirebase(DtoReport dtoReport, DtoAnswer dtoAnswer) {
        int resp = 0;
        mDatabase.child("reports").child("reportIdentifier" + dtoReport.getReportIdentifier()).setValue(dtoReport);

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
