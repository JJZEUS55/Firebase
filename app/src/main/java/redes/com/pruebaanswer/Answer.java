package redes.com.pruebaanswer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.stetho.Stetho;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import redes.com.pruebaanswer.realm.Dao.Dao.DaoAnswer;
import redes.com.pruebaanswer.realm.Dao.Dao.DaoReport;
import redes.com.pruebaanswer.realm.Dao.Dto.DtoAnswer;
import redes.com.pruebaanswer.realm.Dao.Dto.DtoOption;
import redes.com.pruebaanswer.realm.Dao.Dto.DtoReport;

public class Answer extends AppCompatActivity implements View.OnClickListener {
    Button btnEnviar, btnSelect, btnUpdate, btnSendFirebase;
    EditText edit;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Realm.init(this);

    //To initialize Stetho and Stetho-Realm.
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(
                                RealmInspectorModulesProvider.builder(this)
                                        .withDeleteIfMigrationNeeded(true) //if there is any changes in database schema then rebuild bd.
                                        .withMetaTables() //extract table meta data
                                        .withLimit(10000) //by default limit of data id 250, but you can increase with this
                                        .build()
                        )
                        .build());

        setContentView(R.layout.activity_main);
        btnEnviar = findViewById(R.id.btn_firebase);
        btnSelect = findViewById(R.id.btn_select);
        btnUpdate = findViewById(R.id.btn_update);
        btnSendFirebase= findViewById(R.id.btn_firebase_send);

        edit = findViewById(R.id.txt_answer);
        textView = findViewById(R.id.txt_answer2);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DtoReport dtoReport = new DtoReport();
                dtoReport.setReportIdentifier("2");
                dtoReport.setIdentifier("dsadasfdfdg");
                dtoReport.setStartedAt("timestamp");
                dtoReport.setFinishedAt("timestamp");
                dtoReport.setLat("19.51661");
                dtoReport.setFinishedAt("-99.24668");
                dtoReport.setDeviceId("1");
                dtoReport.setData("LALALALALA " + 2);
                dtoReport.setSiteInterestId("INTERESADO " + 2);

                List<DtoAnswer> dtoAnswerList = new ArrayList<>();

                DtoAnswer dtoAnswer = new DtoAnswer();
                dtoAnswer.setIdAnswer("" + 1);
                dtoAnswer.setAnswer("prueba respuesta " + 1);
                dtoAnswer.setCreatedAt("" + 123456789 + 1);
                dtoAnswer.setIndputId("" + 1);
                dtoAnswer.setIdReport("2");
                dtoAnswer.setReportIdentifier("2");

                DtoAnswer dtoAnswer2 = new DtoAnswer();
                dtoAnswer2.setIdAnswer("2");
                dtoAnswer2.setIdReport(dtoReport.getReportIdentifier());
                dtoAnswer2.setAnswer("prueba respuesta " + 2);
                dtoAnswer2.setCreatedAt("" + 123456789 + 1);
                dtoAnswer2.setIndputId("" + 1);
                dtoAnswer2.setReportIdentifier("2");

                DtoAnswer dtoAnswer3 = new DtoAnswer();
                dtoAnswer3.setIdAnswer("3");
                dtoAnswer3.setIdReport(dtoReport.getReportIdentifier());
                dtoAnswer3.setAnswer("prueba respuesta " + 3);
                dtoAnswer3.setCreatedAt("" + 123456789 + 1);
                dtoAnswer3.setIndputId("" + 1);
                dtoAnswer3.setReportIdentifier("2");

                dtoAnswerList.add(dtoAnswer);
                dtoAnswerList.add(dtoAnswer2);
                dtoAnswerList.add(dtoAnswer3);

                Log.i("selectReports", dtoAnswerList.toString());

                dtoReport.getAnswers().add(dtoAnswer);
                dtoReport.getAnswers().add(dtoAnswer2);
                dtoReport.getAnswers().add(dtoAnswer3);

                DaoReport daoReport = new DaoReport(getApplicationContext());
                daoReport.insertRealm(dtoReport);
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DaoReport daoReport = new DaoReport(getApplicationContext());
//                daoReport.select(2);

//                DaoAnswer daoRAnswer = new DaoAnswer(getApplicationContext());
//                daoRAnswer.select("1");
            }
        });

        btnSendFirebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PresenterSend presenterSend = new PresenterSend(getApplicationContext());
                presenterSend.send();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<DtoAnswer> dtoAnswerList = new ArrayList<>();

                DtoAnswer dtoAnswer = new DtoAnswer();
                dtoAnswer.setIdAnswer("" + 1);
                dtoAnswer.setAnswer("prueba respuesta " + 123445);
                dtoAnswer.setCreatedAt("aadasd" + 123456789 + 1);
                dtoAnswer.setIndputId("" + 1);
                dtoAnswer.setReportIdentifier("Jorge554810362 " + 1);

                DtoAnswer dtoAnswer2 = new DtoAnswer();
                dtoAnswer2.setIdAnswer("" + 2);
                dtoAnswer2.setAnswer("prueba respuesta " + 155555555);
                dtoAnswer2.setCreatedAt("asdasd" + 123456789 + 1);
                dtoAnswer2.setIndputId("" + 1);
                dtoAnswer2.setReportIdentifier("Jorge554810362 " + 1);

                DtoAnswer dtoAnswer3 = new DtoAnswer();
                dtoAnswer3.setIdAnswer("" + 3);
                dtoAnswer3.setAnswer("zxczxc azxczx " + 155555555);
                dtoAnswer3.setCreatedAt("axzxczxcxzcxz" + 123456789 + 1);
                dtoAnswer3.setIndputId("" + 3);
                dtoAnswer3.setReportIdentifier("Jorge554810362 " + 1);

                dtoAnswerList.add(dtoAnswer);
                dtoAnswerList.add(dtoAnswer2);
                dtoAnswerList.add(dtoAnswer3);

                DaoAnswer daoRAnswer = new DaoAnswer(getApplicationContext());
                daoRAnswer.updateRealm(dtoAnswerList);
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

    public void selectListData() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Seccion").child("IdSeccion1").child("Question").child("idQuestion1").child("option");


        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = "";
                DtoOption dtoOption = null;
                List<DtoOption> listDto = new ArrayList<>();
                for (DataSnapshot postData : dataSnapshot.getChildren()) {
                    dtoOption = postData.getValue(DtoOption.class);
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

    public void selectOneData() {
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

    public void deleteData() {
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

    private void insertDtoReport() {
        DtoReport dtoReport = new DtoReport();
        dtoReport.setReportIdentifier("" + 2);
        dtoReport.setIdentifier("123123123");
        dtoReport.setStartedAt("timestamp");
        dtoReport.setFinishedAt("timestamp");
        dtoReport.setLat("19.51661");
        dtoReport.setFinishedAt("-99.24668");
        dtoReport.setDeviceId("1");
        dtoReport.setData("LALALALALA " + 2);
        dtoReport.setSiteInterestId("INTERESADO " + 2);

        List<DtoAnswer> dtoAnswerList = new ArrayList<>();
        Map<String, DtoAnswer> dtoAnswerMap = new HashMap<>();
        DtoAnswer dtoAnswer = new DtoAnswer();
        dtoAnswer.setIdAnswer("" + 2);
        dtoAnswer.setAnswer("prueba respuesta " + 2);
        dtoAnswer.setCreatedAt("" + 123456789 + 2);
        dtoAnswer.setIndputId("" + 2);
        dtoAnswer.setReportIdentifier("Jorge554810362 " + 2);

        DtoAnswer dtoAnswer2 = new DtoAnswer();
        dtoAnswer2.setIdAnswer("" + 3);
        dtoAnswer2.setAnswer("prueba respuesta " + 3);
        dtoAnswer2.setCreatedAt("" + 123456789 + 3);
        dtoAnswer2.setIndputId("" + 3);
        dtoAnswer2.setReportIdentifier("Jorge554810362 " + 3);

        dtoAnswerMap.put("answerId" + dtoAnswer.getIdAnswer(), dtoAnswer);
        dtoAnswerMap.put("answerId" + dtoAnswer2.getIdAnswer(), dtoAnswer2);


        dtoAnswerList.add(dtoAnswer);
        dtoAnswerList.add(dtoAnswer2);

        dtoAnswer.setAnswer(edit.getText().toString());


//        DaoAnswer daoAnswer = new DaoAnswer();
//        daoAnswer.insertFirebase(dtoReport, dtoAnswerMap);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == btnEnviar.getId()) {
//            DtoSimpleAnswer dtoAnswer = new DtoSimpleAnswer();
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
