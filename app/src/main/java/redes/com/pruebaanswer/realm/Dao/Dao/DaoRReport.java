package redes.com.pruebaanswer.realm.Dao.Dao;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import redes.com.pruebaanswer.realm.Dao.AppDb;
import redes.com.pruebaanswer.realm.Dao.Dto.DtoReport;

public class DaoRReport {
    private Realm realm;

    public DaoRReport(Context context) {
        realm = AppDb.getAppDbRealm(context);
    }

    public List<DtoReport> select(int idReport) {
        realm.beginTransaction();
        ArrayList<DtoReport> dtoReports = new ArrayList(realm.where(DtoReport.class).equalTo("reportIdentifier", "" + idReport).findAll());
        realm.commitTransaction();
        Log.i("selectReports", dtoReports.toString());
        return dtoReports;
    }

    public int insert(List<DtoReport> dtoReportList) {
        int resp = 0;
        RealmList<DtoReport> dtoReportRealmList = new RealmList<>();
        realm.beginTransaction();
        dtoReportRealmList.addAll(dtoReportList);
        realm.insertOrUpdate(dtoReportList);
        realm.commitTransaction();
        return resp;
    }

    public int insert(DtoReport dtoReportList) {
        int resp = 0;
        RealmList<DtoReport> dtoReportRealmList = new RealmList<>();
        realm.beginTransaction();
        realm.insertOrUpdate(dtoReportList);
        realm.commitTransaction();
        return resp;
    }


    public int deleteFirebase() {
        int resp = 0;
        realm.beginTransaction();

        realm.commitTransaction();
        return resp;
    }


    public int updateFirebase(DtoReport dtoReport) {
        int resp = 0;
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(dtoReport);
        realm.commitTransaction();
        return resp;
    }

}
