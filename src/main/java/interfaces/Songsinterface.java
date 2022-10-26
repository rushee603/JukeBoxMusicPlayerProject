package interfaces;

import models.Songs;

import java.sql.SQLException;
import java.util.List;

public interface Songsinterface {

    List<Songs> display_allSongs();

    List<Songs> sort_Songs(String category);

    List<Songs> search_Songs(String songName);
}