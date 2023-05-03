package pixiv;

import jakarta.servlet.http.Part;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;


public class DBConnection {
    private static Connection connection;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/pixiv", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<Post> getPosts() {
        ArrayList<Post> posts = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM posts"
            );

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                Post post = new Post();
                post.setId(resultSet.getInt("id"));
                post.setAuthor(resultSet.getString("author"));
                post.setImageUrl(resultSet.getString("imageUrl"));
                post.setDescription(resultSet.getString("description"));

                posts.add(post);
            }
            statement.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
        return posts;
    }
    public static void addPost(Post posts) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO posts (author, imageUrl, description) " +
                            "VALUES (?,?,?);"
            );

            statement.setString(1, posts.getAuthor());
            statement.setString(2, posts.getImageUrl());
            statement.setString(3, posts.getDescription());



            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {

        }
    }

//    public static void addImage(String imageUrl) {
////       try {
////            PreparedStatement statement = connection.prepareStatement(
////                    "INSERT INTO images (image) VALUES (?)");
////           statement.setString(1, imageUrl);
////           statement.executeUpdate();
////        } catch (SQLException ex) {
////            ex.printStackTrace();
////        }
//
//    }

    public static String getImage(int id) {
        String imageUrl = null;

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT image FROM images WHERE id = ? "
            );
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                imageUrl = resultSet.getString("image");

            }



            // Использование класса java.net.URL для чтения изображения из потока ввода


        } catch (Exception ex) {

        }
        return imageUrl;
    }
}
