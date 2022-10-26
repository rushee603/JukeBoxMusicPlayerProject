package interfaces;

import models.Podcast;
import models.Songs;

import java.sql.SQLException;
import java.util.List;

public interface Podcastinterface {

    List<Podcast> display_allpodcast();

    List<Podcast> sort_podcast(String category);

    List<Podcast> search_podcast(String podcastName);
}
