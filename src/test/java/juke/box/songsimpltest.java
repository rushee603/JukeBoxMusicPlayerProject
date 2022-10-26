package juke.box;


import DAOimplclass.Songsimpl;
import models.Songs;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class songsimpltest {

       Songsimpl song = null;


        @BeforeEach
        public void setUp() throws SQLException {
            song = new Songsimpl();
        }

        @AfterEach
        public void tearDown() {
           song = null;
        }

    @Test
    public void display_allSongsTest1()
    {
        assertEquals("Phir Se Udd Chale",song.display_allSongs().get(2).getS_name());

    }

    @Test
    public void sort_SongsTest2()
    {
        assertEquals("Gods_Plan",song.sort_Songs("songName").get(1).getS_name());
    }
    @Test
    public void search_Songs()
    {
        assertEquals("S148",song.search_Songs("Options").get(0).getS_id());
    }

}
