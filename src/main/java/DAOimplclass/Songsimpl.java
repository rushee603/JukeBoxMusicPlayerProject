package DAOimplclass;

import interfaces.Songsinterface;
import juke.box.DBConnection;
import models.Songs;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public  class Songsimpl implements Songsinterface{
        Connection con = DBConnection.getConnection();
        Scanner Sc = new Scanner(System.in);

    //-----------------------------------------------display songs -------------------------------------------------

    @Override
    public  List<Songs> display_allSongs() {
        List<Songs> songList = new ArrayList<>();
        try {

            String query="select * from songs";
            Statement st= con.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next())
            {
                String s_id=rs.getString(1);
                String s_name=rs.getString(2);
                String s_artist=rs.getString(3);
                String genres=rs.getString(4);
                String duration=rs.getString(5);
                String songpath=rs.getString(6);
                songList.add(new Songs(s_id,s_name,s_artist,duration,genres,songpath));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return songList;
    }
    //------------------------------------------- Sort Song ---------------------------------------------------------

    @Override
    public List<Songs> sort_Songs(String category) {
        List<Songs>sortedsong = display_allSongs();
        List<Songs> list=new ArrayList<>();

        switch (category)
        {
            case "songName":
                list=sortedsong.stream().sorted(Comparator.comparing(Songs::getS_name)).collect(Collectors.toList());
                break;
            case "genres":
                list=sortedsong.stream().sorted(Comparator.comparing(Songs::getGenres)).collect(Collectors.toList());
                break;
            default:
                System.out.println("choose Correct Option");
        }

        return list;
    }

    //-------------------------------------------------- Song Search --------------------------------------------------

    @Override
    public List<Songs> search_Songs(String songName) {

        List<Songs> Searchingsong = new ArrayList<>();
        try{


            String search="select * from songs where songname="+"'"+songName+"'";

            Statement pst=con.createStatement();
            ResultSet rs=pst.executeQuery(search);
            while (rs.next()){
                Songs src= new Songs(rs.getString("songid"), rs.getString("songname"), rs.getString("artistname"),rs.getString("genres"),rs.getString("duration"), rs.getString("songpath"));
                Searchingsong.add(src);
            }
            } catch (Exception ex) {
            System.out.println(ex);
        }
        return Searchingsong;
    }
}

