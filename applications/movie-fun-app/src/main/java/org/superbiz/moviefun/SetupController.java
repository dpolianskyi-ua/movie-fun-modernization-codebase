package org.superbiz.moviefun;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.superbiz.moviefun.albumapi.AlbumFixtures;
import org.superbiz.moviefun.albumapi.AlbumInfo;
import org.superbiz.moviefun.albumapi.AlbumsClient;
import org.superbiz.moviefun.moviesapi.*;

import java.util.Map;

@Controller
public class SetupController {

    private final MoviesClient moviesClient;
    private final AlbumsClient albumsClient;
    private final MovieFixtures movieFixtures;
    private final AlbumFixtures albumFixtures;

    public SetupController(MoviesClient moviesClient, AlbumsClient albumsClient, MovieFixtures movieFixtures, AlbumFixtures albumFixtures) {
        this.moviesClient = moviesClient;
        this.albumsClient = albumsClient;
        this.movieFixtures = movieFixtures;
        this.albumFixtures = albumFixtures;
    }

    @GetMapping("/setup")
    public String setup(Map<String, Object> model) {

        //call movie-service to get List of Movies
        for (MovieInfo movie : movieFixtures.load()) {
            moviesClient.addMovieInfo(movie);
        }

        //call album-service to get List of Albums
        for (AlbumInfo album : albumFixtures.load()) {
            albumsClient.addAlbumInfo(album);
        }

        model.put("movies", moviesClient.getMovieInfos());
        model.put("albums", albumsClient.getAlbumInfos());

        return "setup";
    }
}
