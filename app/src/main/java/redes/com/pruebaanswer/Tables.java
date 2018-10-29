package redes.com.pruebaanswer;

public class Tables {

    public static final String  TABLE_REPORT = "CREATE TABLE report(" +
            "id_report INTEGER PRIMARY KEY," +
            "id_device TEXT," +
            "id_interest_site INTEGER," +
            "started_at TEXT," +
            "finished_at TEXT," +
            "lat TEXT," +
            "lng TEXT)";

    public static final String  TABLE_QUESTIONS = "CREATE TABLE question(" +
            "id_question INTEGER," +
            "id_seccion INTEGER," +
            "id_type INTEGER," +
            "description TEXT," +
            "required INTEGER," +
            "visibility INTEGER," +
            "order INTEGER," +
            "min_photo INTEGER," +
            "max_photo INTEGER," +
            "answer_default TEXT)";


    public static final String  TABLE_ANSWER = "CREATE TABLE answer(" +
            "id_answer INTEGER PRIMARY KEY," +
            "id_question INTEGER," +
            "id_report INTEGER," +
            "text_answer TEXT," +
            "created_at TEXT," +
            "FOREIGN KEY (id_question) REFERENCES question(id_question)," +
            "FOREIGN KEY (id_report) REFERENCES report(id_report))";

}
