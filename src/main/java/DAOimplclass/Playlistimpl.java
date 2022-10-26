package DAOimplclass;

import juke.box.DBConnection;
import models.Playlist;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Playlistimpl {
    Connection con = DBConnection.getConnection();
    Scanner Sc = new Scanner(System.in);
    List<Playlist> playlists = new ArrayList<Playlist>();

    //-----------------------------------  Create Playlist  --------------------------------------

    public void Createplaylist() {
        try {

            System.out.println("------------ Create New PlayList ----------------");
            System.out.println("Enter Your UserId");
            String userId = Sc.next();

            System.out.println("Enter PlayListId");
            String playlistid = Sc.next();
            System.out.println("Enter PlayList Name");
            String playlistname = Sc.next();

            String query3 = "insert into playlist values(?,?,?)";
            PreparedStatement creatlist = con.prepareStatement(query3);
            creatlist.setString(1, playlistid);
            creatlist.setString(2, playlistname);
            creatlist.setString(3, userId);
            int rows = creatlist.executeUpdate();
            Playlist obj1 = new Playlist(playlistid, playlistname, userId);
            playlists.add(obj1);
            System.out.println("Playlist Added Successfully !! ");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    //----------------------------------  Delete Playlist  ---------------------------------------------


    public void DeletePlaylist() {
        try {
            System.out.println("Enter PlayListId");
            String playlistid = Sc.next();
            String delete = "delete from playlist where playlistid=?";
            PreparedStatement deletelist = con.prepareStatement(delete);
            deletelist.setString(1, playlistid);
            int rows = deletelist.executeUpdate();
            System.out.println("your playlist deleted Successfully");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}












