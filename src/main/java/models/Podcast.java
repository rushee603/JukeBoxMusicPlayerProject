package models;

public class Podcast {
    private String p_id;
    private String p_name;
    private String p_artist;
    private String p_duration;
    private String potcastpath;

    public Podcast() {
    }

    public Podcast(String p_id, String p_name, String p_artist, String p_duration, String potcastpath) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_artist = p_artist;
        this.p_duration = p_duration;
        this.potcastpath = potcastpath;
    }

    public Podcast(String potcastpath) {
        this.potcastpath= potcastpath;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_artist() {
        return p_artist;
    }

    public void setP_artist(String p_artist) {
        this.p_artist = p_artist;
    }

    public String getP_duration() {
        return p_duration;
    }

    public void setP_duration(String p_duration) {
        this.p_duration = p_duration;
    }

    public String getPotcastpath() {
        return potcastpath;
    }

    public void setPotcastpath(String potcastpath) {
        this.potcastpath = potcastpath;
    }

    @Override
    public String toString() {

        return  p_id + "  "+ p_name + "  " + p_artist + "     "+p_duration + "   "+ potcastpath ;
    }

}


