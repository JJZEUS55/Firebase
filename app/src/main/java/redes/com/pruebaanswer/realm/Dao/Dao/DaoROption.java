package redes.com.pruebaanswer.realm.Dao.Dao;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import redes.com.pruebaanswer.realm.Dao.AppDb;
import redes.com.pruebaanswer.realm.Dao.Dto.DtoOption;

public class DaoROption {
    private Realm realm;

    public DaoROption(Context context) {
        realm = AppDb.getAppDbRealm(context);
    }

    public List<DtoOption> select(int idReport) {
        realm.beginTransaction();
        ArrayList<DtoOption> dtoOptions = new ArrayList(realm.where(DtoOption.class).equalTo("id_report", idReport).findAll());
        realm.commitTransaction();
        return dtoOptions;
    }

    public int insertFirebase(List<DtoOption> dtoOptionList) {
        int resp = 0;
        RealmList<DtoOption> dtoOptionRealmList = new RealmList<>();
        realm.beginTransaction();
        dtoOptionRealmList.addAll(dtoOptionList);
        realm.commitTransaction();
        return resp;
    }


    public int deleteFirebase() {
        int resp = 0;
        realm.beginTransaction();


        realm.commitTransaction();
        return resp;
    }


    public int updateFirebase(DtoOption dtoOption) {
        int resp = 0;
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(dtoOption);
        realm.commitTransaction();
        return resp;
    }

}
