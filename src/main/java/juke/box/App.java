package juke.box;

import DAOimplclass.*;

import models.Podcast;
import models.Songs;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws SQLException, UnsupportedAudioFileException, LineUnavailableException, IOException {

        Scanner main1 = new Scanner(System.in);

        System.out.println("---------------------------------------------------------------------");
        System.out.println("        >>>>>>>>>   Welcome To Jukebox Music Player   <<<<<<<<<<    ");
        System.out.println("---------------------------------------------------------------------");


        while (true) {

            System.out.println("Enter Your Choice : \n1.Create Account \n2.Login ");
            int choice = main1.nextInt();
            switch (choice) {
                case 1: {
                    userimpl uii = new userimpl();
                    uii.CreateAccount();
                    break;
                }
                case 2: {
                    userimpl uii = new userimpl();
                    System.out.println("Enter UserId");
                    int i= main1.nextInt();
                    System.out.println("Enter Password");
                    String pass=main1.next();
                    uii.login(i,pass);
                    System.out.println("--------------------------------------------------------------------");
                    break;
                }

            }
            System.out.println("-----------------------------------------------------------------------");
           while(true){
               System.out.println("Enter Your Choice : \n1.Display All Songs \n2.Display all Podcast "+"\n3.play songplaylist "+"\n4.play podcastPlaylist "+
                                                         " \n5.Display Sorted Songs  \n6.Display Sorted Podcast " +
                                                          "\n7. Search songs \n8. Search Podcast \n9.next");
            int choice1 = main1.nextInt();
            switch (choice1) {
                case 1: {
                    List<Songs> Details = new Songsimpl().display_allSongs();
                    Details.stream().forEach(s -> System.out.println(s));
                    System.out.println("--------------------------------------------------------------------");
                    continue;
                }
                case 2: {
                    List<Podcast> pdetails = new Podcastimpl().display_allpodcast();
                    pdetails.stream().forEach(p -> System.out.println(p));
                    System.out.println("--------------------------------------------------------------------");
                    continue;
                }
                case 3:
                {
                    Playlistdetailsimpl playm = new Playlistdetailsimpl();
                List<Songs> address = playm.songslist();
                int i = 0;
                String location = "";
                for (Songs x : address) {
                    location = address.get(i).getSongpath();
                }
                Main main = new Main();
                main.readAudio(location,1);

                System.out.println("--------------------------------------------------------------------");
                continue;
            }
                case 4: {
                    Playlistdetailsimpl playp = new Playlistdetailsimpl();
                    List<Podcast> address1 = playp.Podcastlist();
                    int k = 0;
                    String location = "";
                    for (Podcast x : address1) {
                        location = address1.get(k).getPotcastpath();
                    }
                    Main main = new Main();
                    main.readAudio(location, 1);
                    System.out.println("--------------------------------------------------------------------");
                    continue;
                }


                case 5:{

                    System.out.println("Choose \n1.songName \n2.genres");
                    int fg=main1.nextInt();
                    if(fg==1)
                    {
                        new Songsimpl().sort_Songs("songName").forEach(x-> System.out.println(x));
                    }
                    if(fg==2)
                    {
                        new Songsimpl().sort_Songs("genres").forEach(x-> System.out.println(x));
                    }

                    System.out.println("--------------------------------------------------------------------");
                    continue;
                }
                case 6:{
                    System.out.println("Choose \n1.podcastName \n2.artistName");
                    int fg=main1.nextInt();
                    if(fg==1)
                    {
                        new Podcastimpl().sort_podcast("podcastname").forEach(x-> System.out.println(x));
                    }
                    if(fg==2)
                    {
                        new Podcastimpl().sort_podcast("artistname").forEach(x-> System.out.println(x));
                    }
                    System.out.println("--------------------------------------------------------------------");
                    continue;
                }
                case 7 :
                {        System.out.println("Enter Song Name :");
                        String s_name= main1.next();
                    List<Songs> Seachsongs= new Songsimpl().search_Songs(s_name);
                    Seachsongs.stream().forEach(songs -> System.out.println(songs));
                    System.out.println("--------------------------------------------------------------------");
                    continue;
                }
                case 8 :
                {        System.out.println("Enter podcast Name :");
                    String p_name= main1.next();
                    List<Podcast> SeachPod= new Podcastimpl().search_podcast(p_name) ;
                    SeachPod.stream().forEach(p -> System.out.println(p));
                    System.out.println("--------------------------------------------------------------------");
                    break;
                }
                case 9 :
                    break;
            }
            System.out.println("--------------------------------------------------------------------------");

                System.out.println("1.Create Playlist \n2.Delete Playlist " +
                        "\n3. Display all play details " +
                        "\n4.play Song \n5.play podcast \n6.Exit");
                int choice2 = main1.nextInt();
                switch (choice2) {
                    case 1: {
                        Playlistimpl playl = new Playlistimpl();
                        playl.Createplaylist();
                        System.out.println("--------------------------------------------------------------------");
                        continue;
                    }
                    case 2: {
                        Playlistimpl playl = new Playlistimpl();
                        playl.DeletePlaylist();
                        System.out.println("--------------------------------------------------------------------");
                        continue;
                    }
                    case 3: {
                        Playlistdetailsimpl pld = new Playlistdetailsimpl();
                        pld.display_allplaylist();
                        System.out.println("--------------------------------------------------------------------");
                        continue;
                    }
                    case 4: {
                        Playlistdetailsimpl playm = new Playlistdetailsimpl();
                        List<Songs> address = playm.songslist();
                        int i = 0;
                        String location = "";
                        for (Songs x : address) {
                            location = address.get(i).getSongpath();
                        }
                        System.out.println(location);
                        Main main = new Main();
                        main.readAudio(location,1);

                        System.out.println("--------------------------------------------------------------------");
                        continue;
                    }
                    case 5: {
                        Playlistdetailsimpl playp = new Playlistdetailsimpl();
                        List<Podcast> address1 = playp.Podcastlist();
                        int k = 0;
                        String location = "";
                        for (Podcast x : address1) {
                            location = address1.get(k).getPotcastpath();
                        }
                        Main main = new Main();
                        main.readAudio(location, 1);
                        System.out.println("--------------------------------------------------------------------");
                        continue;
                    }
                    case 6:
                        System.out.println("------------------------ Thank You Visiting ------------------------------");
                        System.exit(0);
                        break;
                    default:
                        System.out.println(" plz Chose Correct Option");
                }
            }

        }
    }
}







