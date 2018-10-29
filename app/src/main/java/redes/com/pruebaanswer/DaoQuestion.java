package redes.com.pruebaanswer;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DaoQuestion {
    private DatabaseReference mDatabase;
    private List<DtoQuestion> dtoQuestionList;


    public DaoQuestion() {

    }

    public List<DtoQuestion> selectFirebase(int idSeccion) {
        mDatabase = FirebaseDatabase.getInstance().getReference("Seccion").child("IdSeccion" + idSeccion).child("Question");
        dtoQuestionList = new ArrayList<>();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postData : dataSnapshot.getChildren()) {
                    DtoQuestion dtoQuestion = postData.getValue(DtoQuestion.class);
                    dtoQuestionList.add(dtoQuestion);
                }
                Log.e("listQuestion", "List " + dtoQuestionList);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return dtoQuestionList;
    }

    public int insertFirebase(int idSeccion) {
        int resp = 0;
//        mDatabase.child("reports").child("reportIdentifier" + dtoReport.getReportIdentifier()).child("answer").child("id_answer" + dtoAnswer.getIdAnswer()).setValue(dtoAnswer);

        return resp;
    }


    public int deleteFirebase() {
        int resp = 0;


        return resp;
    }


    public int updateFirebase(DtoQuestion dtoAnswer) {
        int resp = 0;


        return resp;
    }

}
