package redes.com.pruebaanswer.realm.Dao.Dao;

import android.content.Context;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import redes.com.pruebaanswer.firebase.Dto.DtoSimpleReport;
import redes.com.pruebaanswer.realm.Dao.AppDb;
import redes.com.pruebaanswer.realm.Dao.Dto.DtoAnswer;
import redes.com.pruebaanswer.realm.Dao.Dto.DtoReport;

public class DaoReport {
    private Realm realm;
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;

    public DaoReport(Context context) {
        realm = AppDb.getAppDbRealm(context);
        //TODO INSERTAR ESTAS DE UNA MEJOR FORMA
        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference();
    }

    public DtoReport selectRealm(int idReport) {
        realm.beginTransaction();
        DtoReport dtoReport = realm.where(DtoReport.class).equalTo("reportIdentifier", "" + idReport).findFirst();
        realm.commitTransaction();
        Log.i("selectReports", dtoReport.toString());
        return dtoReport;
    }

    public List<DtoReport> selectToSendRealm() {
        realm.beginTransaction();
        ArrayList<DtoReport> dtoReports = new ArrayList(realm.where(DtoReport.class).equalTo("statusSend", "0").findAll());
        realm.commitTransaction();
        Log.i("selectReports", dtoReports.toString());
        return dtoReports;
    }

    public int insertRealm(List<DtoReport> dtoReportList) {
        int resp = 0;
        RealmList<DtoReport> dtoReportRealmList = new RealmList<>();
        realm.beginTransaction();
        dtoReportRealmList.addAll(dtoReportList);
        realm.insertOrUpdate(dtoReportList);
        realm.commitTransaction();
        return resp;
    }

    public int insertRealm(DtoReport dtoReportList) {
        int resp = 0;
        RealmList<DtoReport> dtoReportRealmList = new RealmList<>();
        realm.beginTransaction();
        realm.insertOrUpdate(dtoReportList);
        realm.commitTransaction();
        return resp;
    }


    public int deleteRealm() {
        int resp = 0;
        realm.beginTransaction();

        realm.commitTransaction();
        return resp;
    }


    public int updateRealm(DtoReport dtoReport) {
        int resp = 0;
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(dtoReport);
        realm.commitTransaction();
        return resp;
    }


    public List<DtoAnswer> selectFirebase() {
        List<DtoAnswer> dtoAnswerList = new ArrayList<>();


        return dtoAnswerList;
    }

    public int insertFirebase(DtoSimpleReport dtoSimpleReport) {
        int resp = 0;
        mDatabase.child("reports").child("reportIdentifier" + dtoSimpleReport.getReportIdentifier()).setValue(dtoSimpleReport);
        Log.e("sendFirebase", "enviado");

        return resp;
    }

    public int insertFirebase(List<DtoSimpleReport> dtoReports) {
        int resp = 0;
        mDatabase.child("reports").setValue(dtoReports);

        return resp;
    }


    public int deleteFirebase() {
        int resp = 0;


        return resp;
    }


    public int updateFirebase(DtoAnswer dtoAnswer) {
        int resp = 0;


        return resp;
    }

}