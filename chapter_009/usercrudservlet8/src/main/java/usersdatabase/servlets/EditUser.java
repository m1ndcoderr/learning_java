package usersdatabase.servlets;

import usersdatabase.DBController;
import usersdatabase.models.Role;
import usersdatabase.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 12.08.2017
 */
public class EditUser extends HttpServlet {
    /**
     * Id of role of usual user.
     */
    private static final int USERID = 3;
    /**
     * Edits the user depending on the user's role in the system.
     *
     * @param req  .
     * @param resp .
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("role").equals("admin")) {
            editByAdmin(req, resp);
        } else if (session.getAttribute("role").equals("just_user")) {
            editByUser(req, resp, session);
        }
    }

    /**
     * Edits user. This method will be called if current user's role == 'admin'.
     *
     * @param req  .
     * @param resp .
     * @throws IOException .
     */
    private void editByAdmin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username"),
                login = req.getParameter("login"),
                email = req.getParameter("email"),
                country = req.getParameter("country"),
                city = req.getParameter("city"),
                roleId = req.getParameter("role_id");
        if (username == null || login == null || email == null || country == null || city == null) {
            req.getSession().setAttribute("error_message",
                    "<p>Required field was empty. Please, check your input.</p>");
            resp.getWriter().write("error");
        } else if (DBController.getController().getUser(login) == null) {
            req.getSession().setAttribute("error_message",
                    "<p>There is no such user with login " + login + ".</p>");
            resp.getWriter().write("error");
        } else {
            Role tmp;
            DBController controller = DBController.getController();
            if (roleId == null) {
                tmp = controller.getUser(login).getRole();
            } else {
                tmp = controller.findRoleById(Integer.valueOf(roleId));
            }
            controller.update(new User(username, login, email, country, city,
                    LocalDate.now(), tmp));
            resp.getWriter().write("adminpage");
        }
    }

    /**
     * Edits user. This method will be called if current user's role == 'just_user'.
     *
     * @param req     .
     * @param resp    .
     * @param session .
     * @throws IOException .
     */
    private void editByUser(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws IOException {
        String username = req.getParameter("username"),
                login = (String) session.getAttribute("login"),
                email = req.getParameter("email"),
                country = req.getParameter("country"),
                city = req.getParameter("city");
        DBController controller = DBController.getController();
        if (username != null && controller.getUser(login) != null) {
            controller.update(new User(username, login, email, country,
                    city, LocalDate.now(), new Role(USERID, "just_user")));
            resp.getWriter().write("userpage");
        } else {
            req.getSession().setAttribute("error_message",
                    "<p>Username or Login field was empty. Please, check your input.</p>");
            resp.getWriter().write("error");
        }
    }
}
