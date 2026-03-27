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
import util.Data;
import util.StepUtil;

import java.io.IOException;
import java.io.PrintWriter;
/* TO:DO
1. Greetengs servlet перенести в jsp
2. оформить jsp
3. добавить тест
4. попереносить файлики(структура проекта)
*/
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
        if (endpoint != null) {
            out.println("<h1>" + endpoint.getText() + "</h1>");
            out.println("<form action='" + req.getContextPath() + "/greetings' method='get'>");
            out.println("<button type='submit'>");
            out.println("Попробуй снова :)");
            out.println("</button>");
        }
        else if (question != null) {
            out.println("<h2>" + question.getQuestionBody() + "</h2>");
            long[] answerIds = question.getNextAnswerId();
            if (answerIds != null && answerIds.length > 0) {
                out.println("<form action='" + req.getContextPath() + "/main-quest' method='post'>");
                Answer firstAnswer = (Answer) StepUtil.getStepById((int) answerIds[0], Data.answers);
                if (firstAnswer != null) {
                    out.println("<button type='submit' name='answerId' value='" + answerIds[0] + "'>");
                    out.println(firstAnswer.getAnswerBody());
                    out.println("</button>");
                }

                if (answerIds.length > 1) {
                    Answer secondAnswer = (Answer) StepUtil.getStepById((int) answerIds[1], Data.answers);
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


        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        int answerId = Integer.parseInt(req.getParameter("answerId"));
        HttpSession session = req.getSession();
        System.out.println("Chosen ID: " + answerId);
        Answer chosenAnswer = (Answer) StepUtil.getStepById(answerId, Data.answers);
        if (chosenAnswer == null) {
            System.out.println("Answer not found for ID: " + answerId);
            resp.sendRedirect(req.getContextPath() + "/main-quest");
            return;
        }
        Question nextQuestion = (Question) StepUtil.getStepById((int)chosenAnswer.getNextQuestionId(), Data.questions);
        EndPoint nextEndpoint = (EndPoint) StepUtil.getStepById((int)chosenAnswer.getNextEndPointId(), Data.endPoints);
        session.setAttribute("question", nextQuestion);
        session.setAttribute("endPoint", nextEndpoint);

        resp.sendRedirect(req.getContextPath() + "/main-quest");
    }
}

