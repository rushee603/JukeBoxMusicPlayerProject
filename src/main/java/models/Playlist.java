package models;

public class Playlist {
    private  String playlistid;
    private  String playlistname;
    private  String userId;

    public Playlist(String playlistid, String playlistname, String userId) {
        this.playlistid = playlistid;
        this.playlistname = playlistname;
        this.userId = userId;
    }

    public String getPlaylistid() {
        return playlistid;
    }

    public void setPlaylistid(String playlistid) {
        this.playlistid = playlistid;
    }

    public String getPlaylistname() {
        return playlistname;
    }

    public void setPlaylistname(String playlistname) {
        this.playlistname = playlistname;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playlistid='" + playlistid + '\'' +
                ", playlistname='" + playlistname + '\'' +
                ", userId=" + userId +
                '}';
    }
}

