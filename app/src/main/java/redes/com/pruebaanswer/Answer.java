package redes.com.pruebaanswer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Answer extends AppCompatActivity implements View.OnClickListener {
    FirebaseDatabase database;
    DatabaseReference mDatabase;
    Button btnEnviar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEnviar = findViewById(R.id.btn_firebase);
//        mDatabase = FirebaseDatabase.getInstance().getReference();
//        database = FirebaseDatabase.getInstance();
//        mDatabase = database.getReference("Probando");
//        mDatabase.setValue("HE RECIVIDO DATOS");
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef =  FirebaseDatabase.getInstance().getReference();
                for (int i = 0; i< 7; i=i+2) {
                    DtoReport dtoReport = new DtoReport();
                    dtoReport.setReportIdentifier(i);
                    dtoReport.setIdentifier("123123123");
                    dtoReport.setStartedAt("timestamp");
                    dtoReport.setFinishedAt("timestamp");
                    dtoReport.setLat("19.51661");
                    dtoReport.setFinishedAt("-99.24668");
                    dtoReport.setDeviceId((i*2) + 5);
                    dtoReport.setData("LALALALALA " + i);
                    dtoReport.setSiteInterestId("INTERESADO " + i);

                    DtoAnswer dtoAnswer = new DtoAnswer();
                    dtoAnswer.setIdAnswer(i);
                    dtoAnswer.setAnswer("prueba respuesta " + i);
                    dtoAnswer.setCreatedAt(123456789 + i);
                    dtoAnswer.setIndputId(i);
                    dtoAnswer.setReportIdentifier("Jorge554810362 " + i);

                    myRef.child("reports").child("reportIdentifier" + dtoReport.getReportIdentifier()).setValue(dtoReport);

                            myRef.child("reports").child("reportIdentifier" + dtoReport.getReportIdentifier()).child("answer").child("id_answer" + dtoAnswer.getIdAnswer()).setValue(dtoAnswer);
                }
                Toast.makeText(getApplicationContext(), "ENVIO EXITOSO", Toast.LENGTH_SHORT).show();
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
