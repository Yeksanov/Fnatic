package pixiv_servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pixiv.Users;

import java.io.IOException;

@WebServlet(value = "/add-posts")
public class AddPostPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Users user = (Users) request.getSession().getAttribute("currentUser");
        if(user!=null) {
            request.getRequestDispatcher("/addPosts_IMG.jsp").forward(request, response);
        } else{
            response.sendRedirect("/login");
        }
    }
}
