package models;



public class Songs {
    private  String S_id;
    private  String s_name;
    private String s_artist;
    private String duration;
    private String genres;

    private  String songpath;

    public Songs() {

    }

    public Songs(String songpath) {
        this.songpath = songpath;
    }

    public Songs(String s_id, String s_name, String s_artist, String duration, String genres, String songpath) {
        S_id = s_id;
        this.s_name = s_name;
        this.s_artist = s_artist;
        this.duration = duration;
        this.genres = genres;
        this.songpath=songpath;
    }

    public Songs(String playlistid, String playlistname, String userId) {
    }

    public String getS_id() {
        return S_id;
    }

    public void setS_id(String s_id) {
        S_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_artist() {
        return s_artist;
    }

    public void setS_artist(String s_artist) {
        this.s_artist = s_artist;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
    public String getSongpath() {
        return songpath;
    }

    public void setSongpath(String songpath) {
        this.songpath =songpath;
    }

    @Override
    public String toString() {
        return  S_id + "  "+ s_name + "   " + s_artist + "        "+ duration + "   " + genres +"    " + songpath ;
    }
}

