package usersdatabase.servlets;

import usersdatabase.DBController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 12.08.2017
 */
public class DeleteUser extends HttpServlet {
    /**
     * Delete user from database.
     *
     * @param req  .
     * @param resp .
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        boolean admin = session.getAttribute("role").equals("admin");
        if (admin) {
            deleteByAdmin(req, resp);
        } else {
            deleteByUser(req, resp, session);
        }
    }

    /**
     * Removes role from database if current user's role == 'admin'.
     *
     * @param req  .
     * @param resp .
     * @throws IOException .
     */
    private void deleteByAdmin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String login = req.getParameter("login");
        if (username == null && login != null) {
            DBController.getController().delete(login);
        } else if (username != null && login == null) {
            DBController.getController().deleteByName(username);
        } else if (username != null) {
            if (DBController.getController().isCredentional(username, login)) {
                DBController.getController().delete(login);
            }
        }
        if (username == null && login == null) {
            req.getSession().setAttribute("error_message",
                    "<p>Username or Login field was empty. "
                            + req.getSession().getAttribute("username") + ", check your input.</p>");
            resp.getWriter().write("error");
        } else {
            resp.getWriter().write("adminpage");
        }
    }

    /**
     * Removes user from database if current user's role == 'just_user'.
     *
     * @param req     .
     * @param resp    .
     * @param session .
     * @throws IOException .
     */
    private void deleteByUser(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws IOException {
        String username = req.getParameter("username");
        String login = req.getParameter("login");
        DBController controller = DBController.getController();
        if (username != null && login != null && controller.isCredentional(username, login)) {
            controller.delete(login); // Deleting user's account,
            resp.getWriter().write("signin"); // and sending message for redirection to start page,
            session.invalidate(); // destroying session.
        } else {
            req.getSession().setAttribute("error_message",
                    "<p>1. Username or Login field was empty, or... "
                            + "<p>2. Such user does not exist. " + "<p>Please, check your input.</p>");
            resp.getWriter().write("error");
        }
    }
}
