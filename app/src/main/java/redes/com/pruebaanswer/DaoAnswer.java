package redes.com.pruebaanswer;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaoAnswer {
    private DatabaseReference mDatabase;
    private List<DtoAnswer> dtoAnswerList;

    public DaoAnswer() {
    }

    public List<DtoAnswer> selectFirebase(int idReport) {
        mDatabase = FirebaseDatabase.getInstance().getReference("reports").child("reportIdentifier" + idReport).child("answer");
        dtoAnswerList = new ArrayList<>();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postData : dataSnapshot.getChildren()) {
                    DtoAnswer dtoAnswer = postData.getValue(DtoAnswer.class);
                    dtoAnswerList.add(dtoAnswer);
                }
                Log.e("listAnswer", "List " + dtoAnswerList);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        return dtoAnswerList;
    }

    public int insertFirebase(DtoReport dtoReport, Map<String, DtoAnswer> dtoAnswerList) {
        int resp = 0;
        mDatabase = FirebaseDatabase.getInstance().getReference("reports").child("reportIdentifier" + dtoReport.getReportIdentifier()).child("answer");
        mDatabase.setValue(dtoAnswerList);

        return resp;
    }


    public int deleteFirebase() {
        int resp = 0;


        return resp;
    }


    public int updateFirebase(DtoReport dtoReport, final DtoAnswer dtoAnswer) {
        int resp = 0;
        mDatabase = FirebaseDatabase.getInstance().getReference("reports").child("reportIdentifier" + dtoReport.getReportIdentifier()).child("answer").child("answerId" + dtoAnswer.getIdAnswer());
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map<String, Object> resultUpdate = new HashMap<>();
                resultUpdate.put("answer", dtoAnswer.getAnswer());
                dataSnapshot.getRef().updateChildren(resultUpdate);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return resp;
    }


}
