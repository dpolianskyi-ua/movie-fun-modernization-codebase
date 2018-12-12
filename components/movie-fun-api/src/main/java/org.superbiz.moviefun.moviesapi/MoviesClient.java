package org.superbiz.moviefun.moviesapi;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

public class MoviesClient {
    private String moviesInfoUrl;
    private RestOperations restOperations;

    private static ParameterizedTypeReference<List<MovieInfo>> movieInfoTypeReference = new ParameterizedTypeReference<List<MovieInfo>>() {
    };

    public MoviesClient(String moviesInfoUrl, RestOperations restOperations) {
        this.moviesInfoUrl = moviesInfoUrl;
        this.restOperations = restOperations;
    }

    public void addMovieInfo(MovieInfo movieInfo) {
        restOperations.postForEntity(moviesInfoUrl, movieInfo, MovieInfo.class);
    }

    public void deleteMovieInfo(Long movieInfoId) {
        restOperations.delete(moviesInfoUrl + "/" + movieInfoId);
    }

    public int countAll() {
        return restOperations.getForObject(moviesInfoUrl + "/count", Integer.class);
    }

    public int count(String field, String key) {
        String uri = UriComponentsBuilder.fromHttpUrl(moviesInfoUrl + "/count")
                .queryParam("field", field)
                .queryParam("key", key)
                .toUriString();

        return restOperations.getForObject(uri, Integer.class);
    }

    public List<MovieInfo> findAll(int start, int pageSize) {
        String uri = UriComponentsBuilder.fromHttpUrl(moviesInfoUrl)
                .queryParam("start", start)
                .queryParam("pageSize", pageSize)
                .toUriString();

        return restOperations.exchange(uri, GET, null, movieInfoTypeReference).getBody();
    }

    public List<MovieInfo> findRange(String field, String key, int start, int pageSize) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(moviesInfoUrl)
                .queryParam("field", field)
                .queryParam("key", key)
                .queryParam("start", start)
                .queryParam("pageSize", pageSize);

        return restOperations.exchange(builder.toUriString(), GET, null, movieInfoTypeReference).getBody();
    }

    public List<MovieInfo> getMovieInfos() {
        return restOperations.exchange(moviesInfoUrl, GET, null, movieInfoTypeReference).getBody();
    }
}
