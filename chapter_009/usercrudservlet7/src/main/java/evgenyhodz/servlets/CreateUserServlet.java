package evgenyhodz.servlets;

import evgenyhodz.DBController;
import evgenyhodz.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;


/**
 * Servlet to create new users.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 15.07.2017
 */
public class CreateUserServlet extends HttpServlet {
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
        req.getRequestDispatcher("/WEB-INF/actions/default.jsp").forward(req, resp);
    }

    /**
     * Send request data to DBController to create a new user in a database.
     *
     * @param req  - request from client to server.
     * @param resp - response to client from server.
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBController controller = DBController.getController();
        String roleId = req.getParameter("role_id");
        if (roleId == null) {
            roleId = "3";
        }
        controller.add(new User(
                req.getParameter("name"),
                req.getParameter("login"),
                req.getParameter("email"),
                req.getParameter("country"),
                req.getParameter("city"),
                LocalDate.now(),
                controller.findRoleById(Integer.parseInt(roleId))));
        resp.sendRedirect(String.format("%s/default", req.getContextPath()));
    }
}
