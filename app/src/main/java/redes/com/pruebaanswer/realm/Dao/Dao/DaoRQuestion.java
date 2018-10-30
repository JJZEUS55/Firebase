package redes.com.pruebaanswer.realm.Dao.Dao;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import redes.com.pruebaanswer.realm.Dao.AppDb;
import redes.com.pruebaanswer.realm.Dao.Dto.DtoQuestion;

public class DaoRQuestion {
    private Realm realm;

    public DaoRQuestion(Context context) {
        realm = AppDb.getAppDbRealm(context);
    }

    public List<DtoQuestion> select(int idReport) {
        realm.beginTransaction();
        ArrayList<DtoQuestion> dtoQuestions = new ArrayList(realm.where(DtoQuestion.class).equalTo("id_report", idReport).findAll());
        realm.commitTransaction();
        return dtoQuestions;
    }

    public int insertFirebase(List<DtoQuestion> dtoQuestionList) {
        int resp = 0;
        RealmList<DtoQuestion> dtoQuestions = new RealmList<>();
        realm.beginTransaction();
        dtoQuestions.addAll(dtoQuestionList);
        realm.commitTransaction();
        return resp;
    }


    public int deleteFirebase() {
        int resp = 0;
        realm.beginTransaction();


        realm.commitTransaction();
        return resp;
    }


    public int updateFirebase(DtoQuestion dtoQuestion) {
        int resp = 0;
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(dtoQuestion);
        realm.commitTransaction();
        return resp;
    }

}
