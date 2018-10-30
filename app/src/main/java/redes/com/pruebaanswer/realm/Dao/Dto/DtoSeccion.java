package redes.com.pruebaanswer.realm.Dao.Dto;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class DtoSeccion extends RealmObject {
    @PrimaryKey
    private String IdSeccion;
    private String Description;
    private String Idform;
    private String name;


    public String getIdSeccion() {
        return IdSeccion;
    }

    public void setIdSeccion(String idSeccion) {
        IdSeccion = idSeccion;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getIdform() {
        return Idform;
    }

    public void setIdform(String idform) {
        Idform = idform;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
