package redes.com.pruebaanswer;

public class DtoOption {
    private int idOption;
    private String IdInputEvent;
    private String value;
    private String order;

    public int getIdOption() {
        return idOption;
    }

    public void setIdOption(int idOption) {
        this.idOption = idOption;
    }

    public String getIdInputEvent() {
        return IdInputEvent;
    }

    public void setIdInputEvent(String idInputEvent) {
        IdInputEvent = idInputEvent;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "DtoOption{" +
                "idOption=" + idOption +
                ", IdInputEvent='" + IdInputEvent + '\'' +
                ", value='" + value + '\'' +
                ", order='" + order + '\'' +
                '}';
    }
}
