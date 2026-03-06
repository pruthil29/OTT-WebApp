/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Movie  {
    
    private String image;
    private int id;
    private String title;
    private String genre;
    private String description;
    private String trailerLink;

    public Movie(int id, String title, String genre, String description, String image, String trailerLink) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.image=image;
        this.trailerLink=trailerLink;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public String getDescription() { return description; }
    public String getImage(){ return image; }
    public String getTrailerLink(){ return trailerLink; }
   
}    

