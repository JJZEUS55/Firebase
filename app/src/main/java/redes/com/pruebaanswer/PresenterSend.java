package redes.com.pruebaanswer;

import android.content.Context;
import android.util.Log;
import redes.com.pruebaanswer.realm.Dao.Dao.DaoReport;
import redes.com.pruebaanswer.realm.Dao.Dto.DtoReport;

public class PresenterSend {
    Context context;
    DaoReport daoReport;
    DaoReport daoReportFirebase;
    DtoReport dtoReport;

    public PresenterSend(Context context) {
        this.context = context;
    }


    public void send(){
        daoReport = new DaoReport(context);
        dtoReport = daoReport.selectRealm(2);
        Log.e("sendFirebase", dtoReport.toString());
        daoReportFirebase = new DaoReport(context);
        daoReportFirebase.insertFirebase(dtoReport.covertToSimple());
    }
}
