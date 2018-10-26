package redes.com.pruebaanswer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Answer extends AppCompatActivity implements View.OnClickListener {
    FirebaseDatabase database;
    DatabaseReference mDatabase;
    Button btnEnviar;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEnviar = findViewById(R.id.btn_firebase);
        textView = findViewById(R.id.txt_answer2);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void insertData() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();
        for (int i = 0; i < 7; i = i + 2) {
            DtoReport dtoReport = new DtoReport();
            dtoReport.setReportIdentifier("" + i);
            dtoReport.setIdentifier("123123123");
            dtoReport.setStartedAt("timestamp");
            dtoReport.setFinishedAt("timestamp");
            dtoReport.setLat("19.51661");
            dtoReport.setFinishedAt("-99.24668");
            dtoReport.setDeviceId("1");
            dtoReport.setData("LALALALALA " + i);
            dtoReport.setSiteInterestId("INTERESADO " + i);

            DtoAnswer dtoAnswer = new DtoAnswer();
            dtoAnswer.setIdAnswer("" + i);
            dtoAnswer.setAnswer("prueba respuesta " + i);
            dtoAnswer.setCreatedAt("" + 123456789 + i);
            dtoAnswer.setIndputId("" + i);
            dtoAnswer.setReportIdentifier("Jorge554810362 " + i);


            myRef.child("reports").child("reportIdentifier" + dtoReport.getReportIdentifier()).setValue(dtoReport);

            myRef.child("reports").child(dtoReport.getReportIdentifier()).child("answer").child(dtoAnswer.getIdAnswer()).setValue(dtoAnswer);
        }
    }

    public void selectListData(){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Seccion").child("IdSeccion1").child("Question").child("idQuestion1").child("option");


        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = "";
                DtoOption dtoOption = null;
                List<DtoOption> listDto = new ArrayList<>();
//                    value = (String) postSnap.child("value").getValue();
                for(DataSnapshot postData : dataSnapshot.getChildren()){
                    dtoOption = dataSnapshot.getValue(DtoOption.class);
                    listDto.add(dtoOption);
                }

                Log.e("listOption", "list " + dataSnapshot);


                textView.setText("Valor es " + dtoOption.getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void selectOneData(){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Seccion").child("IdSeccion1").child("Question").child("idQuestion1").child("option").child("idOption1");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = "";
                DtoOption dtoOption;
//                    value = (String) postSnap.child("value").getValue();
                dtoOption = dataSnapshot.getValue(DtoOption.class);


                textView.setText("Valor es " + dtoOption.getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void updateDataPrueba() {

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Seccion").child("IdSeccion1").child("Question").child("idQuestion1").child("option").child("idOption1");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = "";
                Map<String, Object> resultUpdate = new HashMap<>();
                resultUpdate.put("value", "VALOR DE PRUEBA SETEADO");
                dataSnapshot.getRef().updateChildren(resultUpdate);
                textView.setText("");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void deleteData(){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Seccion").child("IdSeccion1").child("Question").child("idQuestion1").child("option").child("idOption1");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = "";
                Map<String, Object> resultUpdate = new HashMap<>();
//                resultUpdate.put("value", "VALOR DE PRUEBA SETEADO");
                dataSnapshot.getRef().removeValue();
                textView.setText("");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == btnEnviar.getId()) {
//            DtoAnswer dtoAnswer = new DtoAnswer();
//            dtoAnswer.setIdAnswer(1);
//            dtoAnswer.setAnswer("prueba respuesta 1");
//            dtoAnswer.setCreatedAt(123456789);
//            dtoAnswer.setIndputId(1);
//            dtoAnswer.setReportIdentifier("Jorge554810362");
//
//            mDatabase.child("answers").child("id_answer" + dtoAnswer.getIdAnswer()).push().setValue(dtoAnswer);
//            Toast.makeText(getApplicationContext(), "ENVIO EXITOSO", Toast.LENGTH_SHORT).show();
        }
    }
}
