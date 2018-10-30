package redes.com.pruebaanswer.realm.Dao.Dao;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import io.realm.Realm;
import io.realm.RealmList;
import redes.com.pruebaanswer.realm.Dao.AppDb;
import redes.com.pruebaanswer.realm.Dao.Dto.DtoAnswer;

public class DaoRAnswer {
    private Realm realm;

    public DaoRAnswer(Context context) {
        realm = AppDb.getAppDbRealm(context);
    }

    public List<DtoAnswer> select(String idReport) {
        realm.beginTransaction();
        ArrayList<DtoAnswer> dtoAnswerList = new ArrayList(realm.where(DtoAnswer.class).equalTo("idReport", idReport).findAll());
        realm.commitTransaction();
        Log.i("selectAnswers", dtoAnswerList.toString());
        return dtoAnswerList;
    }

    public int insert(List<DtoAnswer> dtoAnswers) {
        int resp = 0;
        RealmList<DtoAnswer> dtoAnswerRealmList = new RealmList<>();
        realm.beginTransaction();
        dtoAnswerRealmList.addAll(dtoAnswers);
        realm.insertOrUpdate(dtoAnswerRealmList);
        realm.commitTransaction();
        return resp;
    }


    public int delete() {
        int resp = 0;
        realm.beginTransaction();


        realm.commitTransaction();
        return resp;
    }


    public int update(List<DtoAnswer> dtoAnswers) {
        int resp = 0;
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(dtoAnswers);
        realm.commitTransaction();
        return resp;
    }


}
