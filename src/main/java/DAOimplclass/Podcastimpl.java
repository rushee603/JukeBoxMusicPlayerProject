package DAOimplclass;

import interfaces.Podcastinterface;
import juke.box.DBConnection;
import models.Podcast;
import models.Songs;


import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Podcastimpl implements Podcastinterface {
    Connection con = DBConnection.getConnection();
    Scanner Sc = new Scanner(System.in);

    //------------------------------------- display podcast ---------------------------------------------------------

    @Override
    public List<Podcast> display_allpodcast() {
        List<Podcast> Podcastlist1=new ArrayList<>();
        try {

            String pquery="select * from podcast";
            Statement st= con.createStatement();
            ResultSet rs=st.executeQuery(pquery);
            while(rs.next())
            {
                String p_id=rs.getString(1);
                String p_name=rs.getString(2);
                String p_artist=rs.getString(3);
                String p_duration=rs.getString(4);
                String podcastpath=rs.getString(5);
                Podcastlist1.add(new Podcast( p_id, p_name, p_artist, p_duration,podcastpath));

            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return Podcastlist1;
    }


    @Override
    public List<Podcast> sort_podcast(String category) {
        List<Podcast>sortedpodcast =  display_allpodcast();
        List<Podcast> list=new ArrayList<>();

        switch (category)
        {
            case "podcastname":
                list=sortedpodcast.stream().sorted(Comparator.comparing(Podcast::getP_name)).collect(Collectors.toList());
                break;
            case "artistname":
                list=sortedpodcast.stream().sorted(Comparator.comparing(Podcast::getP_artist)).collect(Collectors.toList());
                break;
            default:
                System.out.println("choose Correct Option");
        }

        return list;
    }


    @Override
    public List<Podcast> search_podcast(String podcastName) {

        List<Podcast> Searchpodcast = new ArrayList<>();
        try{


            String search="select * from podcast where podcastname="+"'"+podcastName+"'";

            Statement pst=con.createStatement();
            ResultSet rs=pst.executeQuery(search);
            while (rs.next()){
                    Podcast src=  new Podcast(rs.getString("podcastid"), rs.getString("podcastname"), rs.getString("artistname"),rs.getString("duration"), rs.getString("potcastpath"));
                    Searchpodcast.add(src); }
            }
            catch (Exception ex) {
                System.out.println(ex);
            }
            return Searchpodcast;

    }
}

