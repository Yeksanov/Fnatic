package pixiv_servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import pixiv.DBConnection;
import pixiv.Post;
import pixiv.Users;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@WebServlet(value = "/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Users user = (Users) request.getSession().getAttribute("currentUser");

        if(user !=null) {


            String author = request.getParameter("post_author");
            String description = request.getParameter("post_description");

            if (author != null) {
                Post post = new Post();
                post.setAuthor(author);
                post.setDescription(description);

                FileOutputStream outputStream = null;

                Part filePart = request.getPart("post_image");
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                InputStream fileContent = filePart.getInputStream();
                try {

                    // Указываем путь к файлу на локальном сервере MAMP, куда будем сохранять изображение
                    String filePath = "/Applications/MAMP/htdocs/images1/" + fileName;


                    // Получаем URL изображения
                    String contextPath = getServletContext().getContextPath();
//           String imageUrl0 = contextPath + fileName;

                    String imageUrl = "http://localhost:8888/images1/" + fileName;


                    post.setImageUrl(imageUrl);
//            DBConnection.addImage(imageUrl);

                    // Создаем объект FileOutputStream и записываем в него данные из потока входных данных
                    outputStream = new FileOutputStream(new File(filePath));


                    int read = 0;
                    byte[] bytes = new byte[1024];
                    while ((read = fileContent.read(bytes)) != -1) {
                        outputStream.write(bytes, 0, read);
                    }

                    // Отправляем клиенту сообщение об успешной загрузке файла
                    response.getWriter().print("File uploaded successfully");
                } catch (Exception e) {
                    // Обрабатываем ошибки
                    response.getWriter().print("Error: " + e.getMessage());
                } finally {
                    // Закрываем потоки
                    if (fileContent != null) {
                        fileContent.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                }
                DBConnection.addPost(post);
                response.sendRedirect("/");
            }

        } else {
            response.sendRedirect("/login");
        }
    }

}


