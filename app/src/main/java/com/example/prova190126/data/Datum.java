package com.example.prova190126.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("_id")
    @Expose
    private Integer id;
    @SerializedName("films")
    @Expose
    private List<String> films;
    @SerializedName("shortFilms")
    @Expose
    private List<String> shortFilms;
    @SerializedName("tvShows")
    @Expose
    private List<String> tvShows;
    @SerializedName("videoGames")
    @Expose
    private List<String> videoGames;
    @SerializedName("parkAttractions")
    @Expose
    private List<String> parkAttractions;
    @SerializedName("allies")
    @Expose
    private List<Object> allies;
    @SerializedName("enemies")
    @Expose
    private List<Object> enemies;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("url")
    @Expose
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public List<String> getShortFilms() {
        return shortFilms;
    }

    public void setShortFilms(List<String> shortFilms) {
        this.shortFilms = shortFilms;
    }

    public List<String> getTvShows() {
        return tvShows;
    }

    public void setTvShows(List<String> tvShows) {
        this.tvShows = tvShows;
    }

    public List<String> getVideoGames() {
        return videoGames;
    }

    public void setVideoGames(List<String> videoGames) {
        this.videoGames = videoGames;
    }

    public List<String> getParkAttractions() {
        return parkAttractions;
    }

    public void setParkAttractions(List<String> parkAttractions) {
        this.parkAttractions = parkAttractions;
    }

    public List<Object> getAllies() {
        return allies;
    }

    public void setAllies(List<Object> allies) {
        this.allies = allies;
    }

    public List<Object> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Object> enemies) {
        this.enemies = enemies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Datum.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("films");
        sb.append('=');
        sb.append(((this.films == null)?"<null>":this.films));
        sb.append(',');
        sb.append("shortFilms");
        sb.append('=');
        sb.append(((this.shortFilms == null)?"<null>":this.shortFilms));
        sb.append(',');
        sb.append("tvShows");
        sb.append('=');
        sb.append(((this.tvShows == null)?"<null>":this.tvShows));
        sb.append(',');
        sb.append("videoGames");
        sb.append('=');
        sb.append(((this.videoGames == null)?"<null>":this.videoGames));
        sb.append(',');
        sb.append("parkAttractions");
        sb.append('=');
        sb.append(((this.parkAttractions == null)?"<null>":this.parkAttractions));
        sb.append(',');
        sb.append("allies");
        sb.append('=');
        sb.append(((this.allies == null)?"<null>":this.allies));
        sb.append(',');
        sb.append("enemies");
        sb.append('=');
        sb.append(((this.enemies == null)?"<null>":this.enemies));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("imageUrl");
        sb.append('=');
        sb.append(((this.imageUrl == null)?"<null>":this.imageUrl));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
