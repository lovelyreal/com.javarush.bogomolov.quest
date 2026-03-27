package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/greetings")
public class GreetingsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Пример: можно передать данные в JSP
        req.setAttribute("message", "Добро пожаловать в историю!");

        // Переход на JSP
        req.getRequestDispatcher("/WEB-INF/views/greetings.jsp")
                .forward(req, resp);
    }
    }
