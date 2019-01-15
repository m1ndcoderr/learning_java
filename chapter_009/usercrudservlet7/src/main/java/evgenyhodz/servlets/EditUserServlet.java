package evgenyhodz.servlets;

import evgenyhodz.DBController;
import evgenyhodz.models.Role;
import evgenyhodz.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Servlet to edit user.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 15.07.2017
 */
public class EditUserServlet extends HttpServlet {
    /**
     * Forward to default.jsp.
     *
     * @param req  - request from client to server.
     * @param resp - response to client from server.
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user", DBController.getController().findByLogin(req.getParameter("login")));
        req.getRequestDispatcher("/WEB-INF/actions/default.jsp").forward(req, resp);
    }

    /**
     * Send request to DBController to edit user.
     *
     * @param req  - request from client to server.
     * @param resp - response to client from server.
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Role tmp;
        DBController controller = DBController.getController();
        String id = req.getParameter("role_id");
        String login = req.getParameter("txtlogin");
        if (id == null) {
            tmp = controller.getUser(login).getRole();
        } else {
            tmp = controller.findRoleById(Integer.valueOf(id));
        }
        controller.update(new User(
                req.getParameter("txtusername"),
                login,
                req.getParameter("txtemail"),
                req.getParameter("country"),
                req.getParameter("city"),
                LocalDate.now(),
                tmp));
        resp.sendRedirect(String.format("%s/default", req.getContextPath()));
    }
}
