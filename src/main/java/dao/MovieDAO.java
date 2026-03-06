/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Movie;
import util.DBConnection;
import java.sql.*;
import java.util.*;
import static jdk.internal.org.commonmark.internal.Bracket.image;

public class MovieDAO {
    
     public List<Movie> getAllMovies() {

        List<Movie> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM movies";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Movie m = new Movie(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("genre"),
                        rs.getString("description"),
                        rs.getString("image"),
                        rs.getString("trailer_Link")
                        );
                list.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
     public void addMovie(String title, String genre, String description,String image,String trailerLink) {
    try {
        Connection con = DBConnection.getConnection();
        String query = "INSERT INTO movies(title, genre, description,image, trailerLink) VALUES (?, ?, ?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, title);
        ps.setString(2, genre);
        ps.setString(3, description);
        ps.setString(4, image);
        ps.setString(5, trailerLink);
        ps.executeUpdate();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
     public void deleteMovie(int id) {
    try {
        Connection con = DBConnection.getConnection();
        String query = "DELETE FROM movies WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
     public Movie getMovieById(int id) {
    Movie movie = null;
    try {
        Connection con = DBConnection.getConnection();
        String query = "SELECT * FROM movies WHERE id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            movie = new Movie(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("genre"),
                rs.getString("description"),
                 rs.getString("image"),
                 rs.getString("trailer_link")
            );
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return movie;
}
     public void updateMovie(int id, String title,
                        String genre, String description) {

    try {
        Connection con = DBConnection.getConnection();
        String query =
            "UPDATE movies SET title=?, genre=?, description=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, title);
        ps.setString(2, genre);
        ps.setString(3, description);
        ps.setInt(4, id);

        ps.executeUpdate();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
     public List<Movie> searchMovies(String keyword) {

    List<Movie> list = new ArrayList<>();

    try {
        Connection con = DBConnection.getConnection();
        String query = "SELECT * FROM movies WHERE title LIKE ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, "%" + keyword + "%");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Movie m = new Movie(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("genre"),
                rs.getString("description"),
                rs.getString("image"),
                rs.getString("trailer_link")
            );
            list.add(m);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}
}
