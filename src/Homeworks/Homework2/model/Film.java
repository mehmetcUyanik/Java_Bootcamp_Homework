package Homeworks.Homework2.model;

import java.util.ArrayList;

public class Film {

    private String filmName;
    private int year;
    private String director;
    private double imdbPoint;
    private String runTime;
    private ArrayList<Category> catArrayList = new ArrayList<>();
    private ArrayList<Platform> platArrayList = new ArrayList<>();




    public Film(String filmName, int year, String director, double imdbPoint, String runTime) {
        this.filmName = filmName;
        this.year = year;
        this.director = director;
        this.imdbPoint = imdbPoint;
        this.runTime = runTime;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getImdbPoint() {
        return imdbPoint;
    }

    public void setImdbPoint(double imdbPoint) {
        this.imdbPoint = imdbPoint;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public ArrayList<Category> getCatArrayList() {
        return catArrayList;
    }

    public void setCatArrayList(ArrayList<Category> catArrayList) {
        this.catArrayList = catArrayList;
    }

    public ArrayList<Platform> getPlatArrayList() {
        return platArrayList;
    }

    public void setPlayArrayList(ArrayList<Platform> platArrayList) {
        this.platArrayList = platArrayList;
    }

    @Override
    public String toString() {
        return "Film{" +
                "Film='" + filmName + '\'' +
                ", Yıl=" + year +
                ", Yönetmen='" + director + '\'' +
                ", Imdb Puanı=" + imdbPoint +
                ", Süre='" + runTime + '\'' +
                ", Kategori=" + catArrayList +
                ", Platform=" + platArrayList +
                '}';
    }


}
