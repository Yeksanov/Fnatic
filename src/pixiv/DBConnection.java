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



    public static Post getPost(int id) {

        Post post = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM posts " +
                    "WHERE id = ?");

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                post = new Post();
                post.setId(resultSet.getInt("id"));
                post.setAuthor(resultSet.getString("author"));
                post.setImageUrl(resultSet.getString("imageUrl"));
                post.setDescription(resultSet.getString("description"));

            }
            statement.close();

        } catch (Exception e) {
        }


        return post;
    }

    public static void updatePost(Post post) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE posts " +
                    "SET " +
                    "author = ?, " +
                    "imageUrl = ?, " +
                    "description = ? " +
                    "WHERE id = ?");

            statement.setString(1, post.getAuthor());
            statement.setString(2, post.getImageUrl());
            statement.setString(3, post.getDescription());
            statement.setInt(4, post.getId());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Users getUser(String email) {
        Users user = null;
        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM users WHERE email = ?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new Users();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("full_name"));
                user.setRole(resultSet.getInt("role_id"));
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void addUser(Users user) {
        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO users (email, password, full_name, role_id) " +
                    "VALUES (?, ?, ?, ?)");

            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullName());
            statement.setInt(4, user.getRole());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deletePost(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM posts WHERE id = ?");

            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addComment(Comment comment) {
        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO comments (comment, user_id, post_id, post_date) " +
                    "VALUES (?, ?, ?, NOW())");

            statement.setString(1, comment.getComment());
            statement.setLong(2, comment.getUser().getId());
            statement.setLong(3, comment.getPost().getId());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Comment> getComments(int newsId) {

        ArrayList<Comment> comments = new ArrayList<>();

        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT co.id, co.comment, co.post_date, co.post_id, co.user_id, u.full_name " +
                    "FROM comments co " +
                    "INNER JOIN users u ON u.id = co.user_id " +
                    "WHERE co.post_id = ? " +
                    "ORDER BY co.post_date DESC");

            statement.setLong(1, newsId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Comment comment = new Comment();
                comment.setId(resultSet.getInt("id"));
                comment.setComment(resultSet.getString("comment"));
                comment.setPostDate(resultSet.getTimestamp("post_date"));
                Users user = new Users();
                user.setId(resultSet.getLong("user_id"));
                user.setFullName(resultSet.getString("full_name"));
                comment.setUser(user);

                Post post = new Post();
                post.setId(resultSet.getInt("post_id"));
                comment.setPost(post);

                comments.add(comment);
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }




}
