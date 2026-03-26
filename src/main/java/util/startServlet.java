package util;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/start")
public class startServlet extends HttpServlet {
    Integer startQuestionId = 1;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String playerName = (String) req.getParameter("playerName");
        HttpSession currentSession = req.getSession();
        currentSession.setAttribute("playerName", playerName);
        currentSession.setAttribute("questionId", startQuestionId);
        currentSession.setAttribute("question", QuestionUtil.getQuestionById(1));
        resp.sendRedirect(req.getContextPath()+"/main-quest");
    }
}
