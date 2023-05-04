package pixiv_servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pixiv.DBConnection;
import pixiv.Post;

import java.io.IOException;

@WebServlet(value = "/details")
public class DetailsServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = -1;

        try {
            id = Integer.parseInt(request.getParameter("book_id"));
        }catch (Exception e){
        }

        Post post = DBConnection.getPost(id);
        request.setAttribute("postSelected", post);

        request.getRequestDispatcher("/details.jsp").forward(request, response);
    }
}
