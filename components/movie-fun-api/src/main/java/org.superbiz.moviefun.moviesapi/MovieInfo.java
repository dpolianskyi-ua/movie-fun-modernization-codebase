package org.superbiz.moviefun.moviesapi;

import java.util.Objects;

public class MovieInfo {
    private Long id;

    private String title;
    private String director;
    private String genre;
    private int rating;
    private int year;

    public MovieInfo() {
    }

    public MovieInfo(String title,
                     String director,
                     String genre,
                     int rating,
                     int year) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.rating = rating;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieInfo movieInfo = (MovieInfo) o;
        return rating == movieInfo.rating &&
                year == movieInfo.year &&
                Objects.equals(id, movieInfo.id) &&
                Objects.equals(title, movieInfo.title) &&
                Objects.equals(director, movieInfo.director) &&
                Objects.equals(genre, movieInfo.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, director, genre, rating, year);
    }

    @Override
    public String toString() {
        return "MovieInfo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", year=" + year +
                '}';
    }
}
