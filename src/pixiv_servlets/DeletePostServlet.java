package pixiv_servlets;

import pixiv.DBConnection;
import pixiv.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(value = "/delete-post")
public class DeletePostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Users user = (Users) request.getSession().getAttribute("currentUser");
        if (user != null && user.getRole() == 1) {
            int id = Integer.parseInt(request.getParameter("id"));
            DBConnection.deletePost(id);
            response.sendRedirect("/");
        } else {
            response.sendRedirect("/login");
        }
    }

}
