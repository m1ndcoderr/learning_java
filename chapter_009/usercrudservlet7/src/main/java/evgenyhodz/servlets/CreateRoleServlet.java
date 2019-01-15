package evgenyhodz.servlets;

import evgenyhodz.DBController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet to create new roles.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 15.07.2017
 */
public class CreateRoleServlet extends HttpServlet {
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
     * Send request to DBController to create new role.
     *
     * @param req  - request from client to server.
     * @param resp - response to client from server.
     * @throws ServletException .
     * @throws IOException      .
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBController.getController().addRole(req.getParameter("role"));
        resp.sendRedirect(String.format("%s/default", req.getContextPath()));
    }
}