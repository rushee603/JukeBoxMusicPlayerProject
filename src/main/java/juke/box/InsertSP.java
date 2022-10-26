package juke.box;

import models.Podcast;
import models.Songs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertSP {

Scanner Sc = new Scanner(System.in);
Connection con = DBConnection.getConnection();

    public List<Songs> Insert_Songs() {
        List<Songs> Song1 = new ArrayList<>();
        try {

            System.out.println("Enter Song Id");
            String S_id = Sc.next();
            System.out.println("Enter Song Name");
            String s_name = Sc.next();
            System.out.println("Enter Song Genre");
            String genres = Sc.next();
            System.out.println("Enter Artiest Name");
            String s_artist = Sc.next();
            System.out.println("Enter Song Duration");
            String duration = Sc.next();
            System.out.println("Enter The Song Path");
            String songpath = Sc.next();

            String insong = "insert into songs values(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(insong);
            ps.setString(1, S_id);
            ps.setString(2, s_name);
            ps.setString(3, s_artist);
            ps.setString(5, duration);
            ps.setString(4,genres);
            ps.setString(6,songpath);
            ps.executeUpdate();
            System.out.println("Song Added Successfully..!!");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return Song1 ;
    }


    public List<Podcast> Insert_podcast() {

        List<Podcast> Podcast1 = new ArrayList<>();

        try
        {
            System.out.println("Enter Podcast Id");
            String p_id = Sc.next();
            System.out.println("Enter Podcast Name");
            String p_name = Sc.next();
            System.out.println("Enter Artiest Name");
            String p_artist = Sc.next();
            System.out.println("Enter Podcast Duration");
            Time duration =(Time.valueOf(Sc.next()));
            System.out.println("Enter The Podcast Path");
            String podcastpath = Sc.next();

            String insong = "insert into podcast values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(insong);
            ps.setString(1, p_id);
            ps.setString(2, p_name);
            ps.setString(3, p_artist);
            ps.setTime(4,   duration);
            ps.setString(5, podcastpath);
            ps.executeUpdate();
            System.out.println("podcast added Successfully ");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return Podcast1;
    }
}
