package pixiv_servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pixiv.DBConnection;

import java.io.IOException;

@WebServlet(value = "/get-image")
public class GetImageServlet extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


      String imageUrl = null;
       imageUrl = DBConnection.getImage(10);



       request.setAttribute("imageUrl", imageUrl);
        request.getRequestDispatcher("/showImage.jsp").forward(request, response);
    }
}
