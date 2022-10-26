package DAOimplclass;

import juke.box.DBConnection;
import juke.box.Main;
import models.Playlistdetails;
import models.Podcast;
import models.Songs;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.String.format;

public class Playlistdetailsimpl  {

    Connection con = DBConnection.getConnection();
    Scanner Sc = new Scanner(System.in);
    List<Playlistdetails> playlists = new ArrayList();
    Songsimpl songsimpl = new Songsimpl();
    Main main = new Main();
//-----------------------------------------------------------------------------------------------------------------------
    public List<Songs> songslist() throws SQLException {
        List<Songs> list = new ArrayList<>();
        String address = "";
        try {
            String Songs = "select * from songs ";
            PreparedStatement playsong = con.prepareStatement(Songs);
            ResultSet rs = playsong.executeQuery();
            while (rs.next()) {
                address = rs.getString(6);
                list.add(new Songs(address));
            }con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
            public List<Songs> Play() throws SQLException {
            List<Songs> playobj = this.songslist();
            int i = 0;
            for (Songs x : playobj) {
                String location = playobj.get(i).getSongpath();
                main.readAudio(location, 1);
            }

           return null;
        }
        //---------------------------------------------------------------------------------------------------------

    public List<Podcast> Podcastlist() throws SQLException {
        List<Podcast> list = new ArrayList<>();
        String address1 = "";
        try {
            String Podcast1 = "select * from podcast ";
            PreparedStatement play = con.prepareStatement(Podcast1);
            ResultSet rs = play.executeQuery();
            while (rs.next()) {
                address1 = rs.getString(5);
                list.add(new Podcast(address1));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    //-----------------------------------------------------------------------------------------------------------

    public void display_allplaylist() {
        try {

            String query1 = "select * from playlist";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            while (rs.next()) {
                String playlistid = rs.getString(1);
                String playlistname = rs.getString(2);
                String userId = rs.getString(3);
                playlists.add(new Playlistdetails(playlistid, playlistname, userId));

            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(format("%12s %15s %14s ", "userid", "genres","songs   podcast id" ));
        playlists.forEach(x-> System.out.println(x.getP_id()+"     "+x.getS_id()+"      "+x.getPlaylistid()));
    }
}


