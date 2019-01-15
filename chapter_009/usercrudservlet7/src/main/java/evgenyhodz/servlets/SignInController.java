package evgenyhodz.servlets;

import evgenyhodz.DBController;
import evgenyhodz.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 15.07.2017
 */
public class SignInController extends HttpServlet {
    /**
     * Forward to signin.jsp.
     *
     * @param req  - request from client to server.
     * @param resp - response to client from server.
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/actions/signin.jsp").forward(req, resp);
    }

    /**
     * Send request to pass filter.
     *
     * @param req  - request from client to server.
     * @param resp - response to client from server.
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        User user = DBController.getController().getUser(login);
        HttpSession session = req.getSession();
        if (user != null) {
            session.setAttribute("user", user);
            resp.sendRedirect(String.format("%s/default", req.getContextPath()));
        } else {
            req.setAttribute("error", "There is no such user in database.");
            doGet(req, resp);
        }
    }
}
