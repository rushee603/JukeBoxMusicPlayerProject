package models;

public class Playlistdetails {
    private  String playlistid;
    private  String s_id;
    private  String p_id;

    public Playlistdetails(String playlistid, String s_id, String p_id) {
        this.playlistid = playlistid;
        this.s_id = s_id;
        this.p_id = p_id;
    }

    public String getPlaylistid() {
        return playlistid;
    }

    public void setPlaylistid(String playlistid) {
        this.playlistid = playlistid;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }
}
