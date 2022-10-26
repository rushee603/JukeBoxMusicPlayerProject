package juke.box;

import DAOimplclass.Podcastimpl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class Podcastimpltest {

    Podcastimpl pod = null;

    @BeforeEach
    public void setUp() throws SQLException {
        pod = new Podcastimpl();
    }

    @AfterEach
    public void tearDown() {
        pod = null;
    }

    @Test
    public void display_allpodcastTest1()
    {
        assertEquals(3,pod.display_allpodcast().size());
    }

    @Test
    public void sort_PodcastTest2() {
        Assertions.assertEquals("Podcast2", pod.sort_podcast("podcastname").get(1).getP_name());

    }
    @Test
    public void search_Podcast()
    {
        Assertions.assertEquals("P130",pod.search_podcast("Podcast1").get(0).getP_id());
    }


}