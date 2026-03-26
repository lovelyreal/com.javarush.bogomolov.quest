package controller;

import entity.Answer;
import entity.EndPoint;
import entity.Question;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.AnswerUtil;
import util.EndPointUtil;
import util.QuestionUtil;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/main-quest")
public class mainController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        String playerName = (String) session.getAttribute("playerName");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <title>Опрос</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h3>Игрок: " + playerName + "</h3>");
        Question question = (Question) session.getAttribute("question");
        EndPoint endpoint = (EndPoint) session.getAttribute("endPoint");

        if (question != null) {
            out.println("<h2>" + question.getQuestionBody() + "</h2>");
            long[] answerIds = question.getNextAnswerId();
            if (answerIds != null && answerIds.length > 0) {
                out.println("<form action='" + req.getContextPath() + "/main-quest' method='post'>");
                Answer firstAnswer = AnswerUtil.getAnswerById((int) answerIds[0]);
                if (firstAnswer != null) {
                    out.println("<button type='submit' name='answerId' value='" + answerIds[0] + "'>");
                    out.println(firstAnswer.getAnswerBody());
                    out.println("</button>");
                }

                if (answerIds.length > 1) {
                    Answer secondAnswer = AnswerUtil.getAnswerById((int) answerIds[1]);
                    if (secondAnswer != null) {
                        out.println("<button type='submit' name='answerId' value='" + answerIds[1] + "'>");
                        out.println(secondAnswer.getAnswerBody());
                        out.println("</button>");
                    }
                }

                out.println("</form>");
            } else {
                out.println("<p>Нет доступных вариантов ответа</p>");
            }
        }
        if (question == null && endpoint != null) {
            out.println("<h1>" + endpoint.getText() + "</h1>");
            out.println("<form action='" + req.getContextPath() + "/greetings' method='get'>");
            out.println("<button type='submit'>");
            out.println("Попробуй снова :)");
            out.println("</button>");
        }

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        long answerId = Integer.parseInt(req.getParameter("answerId"));
        HttpSession session = req.getSession();

        System.out.println("Chosen ID: " + answerId);
        session.setAttribute("question", QuestionUtil.getQuestionById((int) AnswerUtil.getAnswerById((int) answerId).getNextQuestionId()));
        session.setAttribute("endPoint", EndPointUtil.getEndPointById((int) AnswerUtil.getAnswerById((int) answerId).getNextEndPointId()));
        resp.sendRedirect(req.getContextPath() + "/main-quest");
    }
}

