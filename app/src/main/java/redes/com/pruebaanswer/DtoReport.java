package redes.com.pruebaanswer;

public class DtoReport {
    private long reportIdentifier;
    private String identifier;
    private String startedAt;
    private String finishedAt;
    private String lat;
    private String lng;
    private long deviceId;
    private String data;
    private String siteInterestId;


    public long getReportIdentifier() {
        return reportIdentifier;
    }

    public void setReportIdentifier(long reportIdentifier) {
        this.reportIdentifier = reportIdentifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
    }

    public String getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(String finishedAt) {
        this.finishedAt = finishedAt;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSiteInterestId() {
        return siteInterestId;
    }

    public void setSiteInterestId(String siteInterestId) {
        this.siteInterestId = siteInterestId;
    }
}
