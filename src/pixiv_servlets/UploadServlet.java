package pixiv_servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.*;
import java.nio.file.Paths;

@WebServlet(value = "/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//            // Получаем поток входных данных из запроса
//            InputStream inputStream = request.getInputStream();
//
//            // Создаем объект FileOutputStream и указываем путь к файлу на локальном сервере MAMP
//            String uploadDirPath = "web/images/";
//            String fileName = "my_image.jpg";
//            FileOutputStream outputStream = new FileOutputStream(new File(uploadDirPath + fileName));
//
//            // Записываем данные из потока входных данных в файл на локальном сервере MAMP
//            byte[] buffer = new byte[1024];
//            int bytesRead;
//            while ((bytesRead = inputStream.read(buffer)) != -1) {
//                outputStream.write(buffer, 0, bytesRead);
//            }
//
//            // Закрываем потоки ввода/вывода
//            inputStream.close();
//            outputStream.close();
//
//            // Отправляем клиенту сообщение об успешной загрузке файла
//            response.getWriter().print("File uploaded successfully");
//
//
//    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FileOutputStream outputStream = null;

        Part filePart = request.getPart("file");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        InputStream fileContent = filePart.getInputStream();
        try {
            // Получаем поток входных данных из запроса

            // Указываем путь к файлу на локальном сервере MAMP, куда будем сохранять изображение
            String filePath = "/Applications/MAMP/htdocs/images1/" + fileName;




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
    }

}


