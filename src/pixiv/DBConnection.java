package pixiv;

import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;


public class DBConnection {
    private static Connection connection;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/jdbc_labs", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<Posts> getPosts() {
        ArrayList<Posts> posts = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM posts"
            );

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                Posts post = new Posts();
                post.setId(resultSet.getLong("id"));
                post.setName(resultSet.getString("full_name"));




                posts.add(post);
            }
            statement.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return posts;
    }
    public static void addPost(Posts posts, InputStream inputStream) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO posts (full_name, image) " +
                            "VALUES (?,?)"
            );

            statement.setString(1, posts.getName());
            statement.setBlob(2, inputStream);


            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {

        }
    }

    public static void addImage(String imageUrl) {
       try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO images (image) VALUES (?)");
            statement.setString(1, imageUrl);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public static String getImage(Long id) {
        String imageUrl = null;

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT image FROM images WHERE id = ?"
            );
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                imageUrl = resultSet.getString("url");

            }

        } catch (SQLException ex) {

        }
        return imageUrl;
    }
}
