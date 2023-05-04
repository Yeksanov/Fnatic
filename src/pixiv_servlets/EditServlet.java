package pixiv_servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pixiv.DBConnection;
import pixiv.Post;

import java.io.IOException;

@WebServlet(value = "/edit-post")
public class EditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("post_id"));
        String author = request.getParameter("post_author");
        String imageUrl = request.getParameter("post_image");
        String description = request.getParameter("post_description");

        Post post = DBConnection.getPost(id);
        if(post !=null ) {
            post.setAuthor(author);
            post.setImageUrl(imageUrl);
            post.setDescription(description);
            DBConnection.updateBook(post);
            response.sendRedirect("/details?post_id=" + id);
        } else  {
            response.sendRedirect("/");
        }

    }
}
