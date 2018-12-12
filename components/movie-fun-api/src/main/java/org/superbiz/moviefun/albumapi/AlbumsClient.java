package org.superbiz.moviefun.albumapi;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestOperations;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

public class AlbumsClient {
    private String albumsInfoUrl;
    private RestOperations restOperations;

    private static ParameterizedTypeReference<List<AlbumInfo>> albumInfoTypeReference = new ParameterizedTypeReference<List<AlbumInfo>>() {
    };

    public AlbumsClient(String albumsInfoUrl, RestOperations restOperations) {
        this.albumsInfoUrl = albumsInfoUrl;
        this.restOperations = restOperations;
    }

    public void addAlbumInfo(AlbumInfo albumInfo) {
        restOperations.postForEntity(albumsInfoUrl, albumInfo, AlbumInfo.class);
    }

    public AlbumInfo find(long id) {
        return restOperations.getForEntity(albumsInfoUrl + "/" + id, AlbumInfo.class).getBody();
    }

    public List<AlbumInfo> getAlbumInfos() {
        return restOperations.exchange(albumsInfoUrl, GET, null, albumInfoTypeReference).getBody();
    }
}
