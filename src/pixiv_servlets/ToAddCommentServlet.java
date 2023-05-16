package pixiv_servlets;

import pixiv.Comment;
import pixiv.DBConnection;
import pixiv.Post;
import pixiv.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/add-comment")
public class ToAddCommentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Users user = (Users) request.getSession().getAttribute("currentUser");

        if (user != null) {

            String commentText = request.getParameter("comment");
            int postId = Integer.parseInt(request.getParameter("post_id"));

            Post post = DBConnection.getPost(postId);

            if (post != null) {

                Comment comment = new Comment();
                comment.setPost(post);
                comment.setUser(user);
                comment.setComment(commentText);

                DBConnection.addComment(comment);

                response.sendRedirect("/details?post_id="+postId);

            }else{
                response.sendRedirect("/");
            }

        } else {
            response.sendRedirect("/login");
        }
    }
}
